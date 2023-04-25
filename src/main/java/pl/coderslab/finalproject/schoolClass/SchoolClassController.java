package pl.coderslab.finalproject.schoolClass;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.student.StudentRepository;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.subject.SubjectRepository;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/class")
@Controller
public class SchoolClassController {
    //michał
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public SchoolClassController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    //michał
    @GetMapping("/all")
    public String allClasses(Model model){
        List<SchoolClass> classes = schoolClassRepository.findAll();
        List<String> extStrings = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int size;
        for(SchoolClass schoolClass : classes){
            size = schoolClass.getSubjects().size();
            int i = 0;
            for(Subject subject : schoolClass.getSubjects()){
                String[] arr = subject.getName().split(" ");
                str.append(arr[arr.length-1].toLowerCase(), 0, 3);
                if(i<size-1){
                    str.append("-");
                }
                i++;
            }
            extStrings.add(str.toString());
            str.setLength(0);
        }
        model.addAttribute("ext",extStrings);
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
        model.addAttribute("subjects", subjectRepository.findAll());
        return "class/add";
    }

    //bartek
    @PostMapping("/add")
    public String addClass(HttpServletRequest request) {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(request.getParameter("name"));
        schoolClass.setTutor(teacherRepository.findTeacherById(Long.parseLong(request.getParameter("tutorId"))));
        int c = 0;
        List<Subject> subjects = new ArrayList<>();
        for(Subject s : subjectRepository.findAll()){
            String str = request.getParameter("subjectName" + c);
            if(str != null){
                subjects.add(subjectRepository.findSubjectByName(str));
            }
            c++;
        }
        schoolClass.setSubjects(subjects);
        schoolClassRepository.save(schoolClass);
        return "redirect:all";
    }
    //bartek
    @GetMapping("/update/{id}")
    public String updateClass(@PathVariable Long id, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        session.setAttribute("classId",id);
        SchoolClass schoolClass = schoolClassRepository.getById(id);
        List<Subject> subjects = subjectRepository.findAll();
        List<Subject> ext = schoolClass.getSubjects();
        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("subjects",subjects);
        model.addAttribute("ext",ext);
        return "class/update";
    }
    @PostMapping("/update/{id}")
    public String updateClass(@PathVariable Long id, HttpServletRequest request){
        SchoolClass schoolClass = schoolClassRepository.getById(id);
        schoolClass.setTutor(teacherRepository.getById(Long.parseLong(request.getParameter("tutorId"))));
        schoolClass.setName(request.getParameter("name"));
        int c = 0;
        List<Subject> subjects = new ArrayList<>();
        for(Subject s : subjectRepository.findAll()){
            String str = request.getParameter("subjectName" + c);
            if(str != null){
                subjects.add(subjectRepository.findSubjectByName(str));
            }
            c++;
        }
        schoolClass.setSubjects(subjects);
        schoolClassRepository.save(schoolClass);
        return "redirect:/class/all";
    }
    //bartek
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        SchoolClass schoolClass = schoolClassRepository.getById(id);
        model.addAttribute("schoolClass",schoolClass);
        List<Student> students = studentRepository.findStudentsBySchoolClassId(id);
        if(students.size()>0) {
            return "class/removeStudentsNotification";
        } else {
            return "class/delete";
        }
    }
    //bartek
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        schoolClassRepository.deleteById(id);
        return "redirect:/class/all";
    }
}
