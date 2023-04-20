package pl.coderslab.finalproject.schoolClass;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.student.StudentDao;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/class")
@Controller
public class SchoolClassController {
    //michał
    private final SchoolClassDao schoolClassDao;
    private final StudentDao studentDao;
    private final TeacherDao teacherDao;

    public SchoolClassController(SchoolClassDao schoolClassDao, StudentDao studentDao, TeacherDao teacherDao){
        this.schoolClassDao = schoolClassDao;
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
    }
    //bartek
    @RequestMapping("/list")
    public String userHome(Model model){
        List<SchoolClass> classes = schoolClassDao.schoolClassList();
        model.addAttribute("classes",classes);
        return "class/all";
    }
    //michał
    @GetMapping("/all")
    public String allClasses(Model model){
        List<SchoolClass> classes = schoolClassDao.schoolClassList();
        model.addAttribute("classes", classes);
        return "class/all";
    }
    //michał
    @GetMapping("/studentlist/{id}")
    public String classStudents(@PathVariable Long id, Model model, HttpServletRequest request){
        //sesja bartek
        HttpSession sess = request.getSession();
        sess.setAttribute("classId",id);
        List<Student> students = studentDao.classStudents(id);
        model.addAttribute("students", students);
        model.addAttribute("classId",id);
        return "class/studentlist";
    }
    //bartek
    @GetMapping("/add")
    public String addClass(Model model){
        List<Teacher> teachers = teacherDao.allTeachers();
        model.addAttribute("teachers", teachers);
        return "class/add";
    }

    //bartek
    @PostMapping("/add")
    public String addClass(HttpServletRequest request){
        String name = request.getParameter("name");
        String tutorId = request.getParameter("tutorId");
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName(name);
        Teacher tutor = teacherDao.specificTeacher(Long.parseLong(tutorId));
        schoolClass.setTutor(tutor);
        schoolClassDao.addSchoolClass(schoolClass);
        return "redirect:all";
    }
}
