package pl.coderslab.finalproject.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.mark.MarkRepository;
import pl.coderslab.finalproject.parent.Parent;
import pl.coderslab.finalproject.parent.ParentRepository;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.mark.Mark;
import pl.coderslab.finalproject.schoolClass.SchoolClassRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    //michał
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final MarkRepository markRepository;
    private final ParentRepository parentRepository;

    public StudentController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository, MarkRepository markRepository, ParentRepository parentRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.markRepository = markRepository;
        this.parentRepository = parentRepository;
    }

    //michał
    @RequestMapping("/all")
    public String allStudents(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student/all";
    }
    //michał
    @RequestMapping("/{id}")
    public String specificStudent(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        HttpSession sess = request.getSession();
        model.addAttribute("classId",sess.getAttribute("classId"));
        Student s = studentRepository.getById(id);
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
    //michał, na koncu poprawki bartek
    @PostMapping("/add")
    public String addStudent(HttpServletRequest request){
        HttpSession session = request.getSession();
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setSchoolClass(schoolClassRepository.getById(Long.parseLong(session.getAttribute("classId").toString())));
        student.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        String phoneNumber1 = request.getParameter("parentOnePhoneNumber");
        String phoneNumber2 = request.getParameter("parentTwoPhoneNumber");
        String parentOneFirstName = request.getParameter("parentOneFirstName");
        String parentTwoFirstName = request.getParameter("parentTwoFirstName");
        String parentOneLastName = request.getParameter("parentOneLastName");
        String parentTwoLastName = request.getParameter("parentTwoLastName");
        if(parentRepository.countParentByPhoneNumber(phoneNumber1) == 0){
            Parent parent1 = new Parent();
            parent1.setFirstName(parentOneFirstName);
            parent1.setLastName(parentOneLastName);
            parent1.setPhoneNumber(phoneNumber1);
            parentRepository.save(parent1);
            student.setFirstParent(parent1);
        }else {
            student.setFirstParent(parentRepository.getDistinctByPhoneNumber(phoneNumber1));
        }
        if(parentRepository.countParentByPhoneNumber(phoneNumber2) == 0){
            Parent parent2 = new Parent();
            parent2.setFirstName(parentTwoFirstName);
            parent2.setLastName(parentTwoLastName);
            parent2.setPhoneNumber(phoneNumber2);
            parentRepository.save(parent2);
            student.setSecondParent(parent2);
        } else {
            student.setSecondParent(parentRepository.getDistinctByPhoneNumber(phoneNumber2));
        }
        studentRepository.save(student);
        return "redirect:/class/studentlist/" + session.getAttribute("classId");

    }
    //michał(nie wiemy czy działa nie testowaliśmy)
    @DeleteMapping("/remove/{id}")
    public String removeStudent(@PathVariable  Long id){
        studentRepository.delete(studentRepository.getById(id));
        return "student/remove";
    }
    //michał zaczal, bartek sesja i lista klas
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Student s = studentRepository.getById(id);
        model.addAttribute("student", s);
        List<SchoolClass> c = schoolClassRepository.findAll();
        model.addAttribute("classes",c);
        return "student/update";
    }

    //50/50
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long classId = Long.parseLong(session.getAttribute("classId").toString());
        Student s = studentRepository.getById(id);
        s.setFirstName(request.getParameter("firstName"));
        s.setLastName(request.getParameter("lastName"));
        s.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        s.setSchoolClass(schoolClassRepository.getById(Long.parseLong(request.getParameter("classId"))));
        studentRepository.save(s);
        return "redirect:/class/studentlist/"+classId;
    }
    //michał
    @GetMapping("/marks/{id}")
    public String studentMarks(@PathVariable Long id, Model model){
        List<Mark> marks = markRepository.findAllByStudent(studentRepository.getById(id));
        Student s = studentRepository.getById(id);
        model.addAttribute("student",s);
        model.addAttribute("marks", marks);
        return "student/marks";

    }

}