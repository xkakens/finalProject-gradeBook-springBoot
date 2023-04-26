package pl.coderslab.finalproject.student;

import org.aspectj.asm.IModelFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.mark.MarkRepository;
import pl.coderslab.finalproject.parent.Parent;
import pl.coderslab.finalproject.parent.ParentRepository;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.mark.Mark;
import pl.coderslab.finalproject.schoolClass.SchoolClassRepository;
import pl.coderslab.finalproject.security.user.UserRepository;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.subject.SubjectRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    //michał
    private final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final MarkRepository markRepository;
    private final ParentRepository parentRepository;
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public StudentController(StudentRepository studentRepository,
                             SchoolClassRepository schoolClassRepository,
                             MarkRepository markRepository,
                             ParentRepository parentRepository,
                             SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.markRepository = markRepository;
        this.parentRepository = parentRepository;
        this.subjectRepository = subjectRepository;
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
        Student s = studentRepository.getById(id);
        model.addAttribute("student", s);
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
    public String addStudentPost(HttpServletRequest request, Model model,
                                 @Valid @ModelAttribute Student checkStudent, BindingResult result){
        HttpSession session = request.getSession();
        if(result.hasErrors() || request.getParameter("dateOfBirth").equals("")){
            model.addAttribute("path", "/student/add");
            return "wrongData";
        }
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setSchoolClass(schoolClassRepository.getById(Long.parseLong(session.getAttribute("classId").toString())));
        student.setDateOfBirth(request.getParameter("dateOfBirth"));
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
    public String updateStudent(@PathVariable Long id, Model model){
        Student s = studentRepository.getById(id);
        model.addAttribute("student", s);
        List<SchoolClass> c = schoolClassRepository.findAll();
        model.addAttribute("classes",c);
        return "student/update";
    }

    //50/50
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, HttpServletRequest request, Model model,
                         @Valid @ModelAttribute Student checkStudent, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("path", "/student/update/" + id);
            return "wrongData";
        }
        Student s = studentRepository.getById(id);
        SchoolClass sClass = s.getSchoolClass();
        Long classId = sClass.getId();
        s.setFirstName(request.getParameter("firstName"));
        s.setLastName(request.getParameter("lastName"));
        s.setDateOfBirth((request.getParameter("dateOfBirth")));
        s.setSchoolClass(schoolClassRepository.getById(Long.parseLong(request.getParameter("classId"))));
        studentRepository.save(s);
        return "redirect:/class/studentlist/"+classId;
    }
    //michał
    @GetMapping("/marks/{id}")
    public String studentMarks(@PathVariable Long id, Model model){
        Student s = studentRepository.getById(id);
        List<Mark> marks = markRepository.findAllByStudent(s);
        marks.sort(Comparator.comparing(Mark::getSubject, Comparator.comparing(Subject::getName)));
        model.addAttribute("student", s);
        model.addAttribute("marks", marks);
        model.addAttribute("subjects",subjectRepository.findAll());
        List<Integer> numberOfMarks = new ArrayList<>();
        for(Subject ss : subjectRepository.findAll()){
            numberOfMarks.add(markRepository.findMarksByStudentIdAndSubjectId(id,ss.getId()).size());
        }
        model.addAttribute("numberOfMarks",numberOfMarks);
        return "student/marks";

    }

    //bartek
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        Student student = studentRepository.getById(id);
        model.addAttribute("student",student);


        return "student/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id, HttpServletRequest request){
        Student student = studentRepository.getById(id);
        studentRepository.delete(student);
        List<Mark> marks = markRepository.findAllByStudent(student);
        markRepository.deleteAll(marks);
        return "redirect:/class/studentlist/"+request.getSession().getAttribute("classId");
    }

    @GetMapping("/users/{id}")
    public String users(Model model, @PathVariable long id){
        model.addAttribute("users",userRepository.findUsersByStudents_Id(id));
        model.addAttribute("student",studentRepository.getById(id));
        return "student/users";
    }
}