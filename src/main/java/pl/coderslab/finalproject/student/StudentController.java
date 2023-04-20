package pl.coderslab.finalproject.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.mark.MarkDao;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.schoolClass.SchoolClassDao;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.mark.Mark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    //michał
    private StudentDao studentDao;
    private SchoolClassDao schoolClassDao;
    private MarkDao markDao;
    private StudentRepository studentRepository;
    //czesc konstruktora bartek
    public StudentController(StudentDao studentDao, SchoolClassDao schoolClassDao, MarkDao markDao){
        this.studentDao = studentDao;
        this.schoolClassDao = schoolClassDao;
        this.markDao = markDao;
    }
    //michał
    @RequestMapping("/all")
    public String allStudents(Model model){
        List<Student> students = studentDao.allStudents();
        model.addAttribute("students", students);
        return "student/all";
    }
    //michał
    @RequestMapping("/{id}")
    public String specificStudent(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        HttpSession sess = request.getSession();
        model.addAttribute("classId",sess.getAttribute("classId"));
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student", s);
        LocalDate dateOfBirth = s.getDateOfBirth();
        return "student/specific";
    }
    //michał, bartek sesja
    @GetMapping("/add")
    public String addStudent(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        model.addAttribute("classId",session.getAttribute("classId"));
        return "student/add";
    }
    //michał
    @PostMapping("/add")
    public String addStudent(HttpServletRequest request){
        HttpSession session = request.getSession();
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setSchoolClass(schoolClassDao.specificClass(Long.parseLong(session.getAttribute("classId").toString())));
        student.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        studentDao.addStudent(student);
        return "redirect:/class/studentlist/" + session.getAttribute("classId");
    }
    //michał(nie wiemy czy działa nie testowaliśmy)
    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable  Long id){
        studentDao.removeStudent(id);
        return "student/remove";
    }
    //michał zaczal, bartek sesja i lista klas
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student", s);
        List<SchoolClass> c = schoolClassDao.schoolClassList();
        model.addAttribute("classes",c);
        return "student/update";
    }

    //50/50
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long classId = Long.parseLong(session.getAttribute("classId").toString());
        Student s = studentDao.specificStudent(id);
        s.setFirstName(request.getParameter("firstName"));
        s.setLastName(request.getParameter("lastName"));
        s.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        s.setSchoolClass(schoolClassDao.specificClass(Long.parseLong(request.getParameter("classId"))));
        studentDao.updateStudent(s);
        return "redirect:/class/studentlist/"+classId;
    }
    //michał
    @GetMapping("/marks/{id}")
    public String studentMarks(@PathVariable Long id, Model model){
        List<Mark> marks = markDao.markList(id);
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student",s);
        model.addAttribute("marks", marks);
        return "student/marks";

    }

}