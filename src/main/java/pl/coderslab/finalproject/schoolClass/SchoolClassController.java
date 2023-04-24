package pl.coderslab.finalproject.schoolClass;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.student.StudentRepository;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/class")
@Controller
public class SchoolClassController {
    //michał
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final TeacherRepository teacherRepository;

    public SchoolClassController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.teacherRepository = teacherRepository;
    }


    //bartek
    @RequestMapping("/list")
    public String userHome(Model model){
        List<SchoolClass> classes = schoolClassRepository.findAll();
        model.addAttribute("classes",classes);
        return "class/all";
    }
    //michał
    @GetMapping("/all")
    public String allClasses(Model model){
        List<SchoolClass> classes = schoolClassRepository.findAll();
        model.addAttribute("classes", classes);
        return "class/all";
    }
    //michał
    @GetMapping("/studentlist/{id}")
    public String classStudents(@PathVariable Long id, Model model, HttpServletRequest request){
        //sesja bartek
        HttpSession sess = request.getSession();
        sess.setAttribute("classId",id);
        List<Student> students = studentRepository.findStudentsBySchoolClassId(id);
        model.addAttribute("students", students);
        model.addAttribute("classId",id);
        model.addAttribute("schoolClass",schoolClassRepository.getById(id));
        return "class/studentlist";
    }
    //bartek
    @GetMapping("/add")
    public String addClass(Model model){
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "class/add";
    }

    //bartek
    @PostMapping("/add")
    public String addClass(HttpServletRequest request){
        String name = request.getParameter("name");
        Long tutorId = Long.parseLong(request.getParameter("tutorId"));
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(name);
        Teacher tutor = teacherRepository.findTeacherById(tutorId);
        schoolClass.setTutor(tutor);
        schoolClassRepository.save(schoolClass);
        return "redirect:all";
    }
    //bartek
    @GetMapping("/update/{id}")
    public String updateClass(@PathVariable Long id, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        session.setAttribute("classId",id);
        model.addAttribute("schoolClass", schoolClassRepository.getById(id));
        model.addAttribute("teachers", teacherRepository.findAll());
        return "class/update";
    }

    @PostMapping("/update/{id}")
    public String updateClass(@PathVariable Long id, HttpServletRequest request){
        SchoolClass schoolClass = schoolClassRepository.getById(id);

        schoolClass.setName(request.getParameter("name"));
        schoolClassRepository.save(schoolClass);
        return "redirect:/class/all";
    }

}
