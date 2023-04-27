package pl.coderslab.finalproject.student;

import net.bytebuddy.asm.Advice;
import org.aspectj.asm.IModelFilter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
import pl.coderslab.finalproject.security.role.Role;
import pl.coderslab.finalproject.security.role.RoleRepository;
import pl.coderslab.finalproject.security.user.User;
import pl.coderslab.finalproject.security.user.UserRepository;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.subject.SubjectRepository;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
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
    private final RoleRepository roleRepository;
    private final TeacherRepository teacherRepository;

    public StudentController(StudentRepository studentRepository,
                             SchoolClassRepository schoolClassRepository,
                             MarkRepository markRepository,
                             ParentRepository parentRepository,
                             SubjectRepository subjectRepository,
                             UserRepository userRepository,
                             RoleRepository roleRepository,
                             TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.markRepository = markRepository;
        this.parentRepository = parentRepository;
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.teacherRepository = teacherRepository;
    }

    //michał
    @RequestMapping("/all")
    public String allStudents(Model model, @AuthenticationPrincipal UserDetails customUser){
        User user = userRepository.findByUsername(customUser.getUsername());
        Set<Role> roles = user.getRoles();
        Role admin = roleRepository.findByName("ADMIN");
        Role student = roleRepository.findByName("student");
        Role teacher = roleRepository.findByName("teacher");
        List<Student> students = new ArrayList<>();
        if(roles.contains(admin)){
            students = studentRepository.findAllByOrderByLastNameAsc();
        } else if(roles.contains(student)){
            List<Long> ids = new ArrayList<>();
            for(Student s : user.getStudents()){
                ids.add(s.getId());
            }
            students = studentRepository.findAllById(ids);
        } else if(roles.contains(teacher)){
            Teacher teacherObj = teacherRepository.findTeacherByUser(user);
            List<Subject> subjects = subjectRepository.findSubjectsByTeachers_id(teacherObj.getId());
            List<SchoolClass> classes = new ArrayList<>();
            for(SchoolClass schoolClass : schoolClassRepository.findAll()){
                boolean flaga = false;
                for(Subject su : subjects){
                    if(schoolClass.getSubjects().contains(su)){
                        flaga = true;
                        break;
                    }
                }
                if(flaga){
                    classes.add(schoolClass);
                }
            }
            students = new ArrayList<>();
            for(SchoolClass schoolClass : classes){
                List<Student> studentsPart = studentRepository.findStudentsBySchoolClassOrderByLastNameAsc(schoolClass);
                students.addAll(studentsPart);
            }
        }
        model.addAttribute("students", students);
        return "student/all";
    }
    //michał
    @RequestMapping("/{id}")
    public String specificStudent(@PathVariable Long id, Model model, HttpServletRequest request, @AuthenticationPrincipal UserDetails customUser){
        Student s = studentRepository.getById(id);
        User user = userRepository.findByUsername(customUser.getUsername());
        if(user.getRoles().contains(roleRepository.findByName("ADMIN"))){
            model.addAttribute("student", s);
        } else if (user.getRoles().contains(roleRepository.findByName("teacher"))){
            model.addAttribute("student", s);
        } else if (user.getRoles().contains(roleRepository.findByName("student"))){
            User userr = userRepository.findByUsername(user.getUsername());
            List<Student> studentsOfUser = userr.getStudents();
            if(!studentsOfUser.contains(studentRepository.getById(id))){
                return "security/403";
            }
            model.addAttribute("student", s);
        }

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
        String dateStr = request.getParameter("dateOfBirth");
        LocalDate date = LocalDate.parse(dateStr);
        int yearsStd = date.getYear();
        System.out.println(date);
        LocalDate today = LocalDate.now();
        int yearToday = today.getYear();
        int time = yearToday - yearsStd;
        System.out.println(time);
        if(result.hasErrors() || time < 8 || time > 15){
            model.addAttribute("path", "/student/add");
            return "wrongData";
        }
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setSchoolClass(schoolClassRepository.getById(Long.parseLong(session.getAttribute("classId").toString())));
        student.setDateOfBirth(dateStr);
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
    public String studentMarks(@PathVariable Long id, Model model,
                               @AuthenticationPrincipal UserDetails customUser){
        User user = userRepository.findByUsername(customUser.getUsername());
        Role student = roleRepository.findByName("student");
        Role teacher = roleRepository.findByName("teacher");
        List<Student> students = user.getStudents();
        Set<Role> roles = user.getRoles();
        List<Subject> subjects = new ArrayList<>();
        if(roles.contains(student)) {
            if(!students.contains(studentRepository.getById(id))) {
                return "security/403";
            }
            subjects = subjectRepository.findAll();
            model.addAttribute("subjects",subjects);
        } else if(roles.contains(teacher)){
            Teacher teacher1 = teacherRepository.findTeacherByUser(user);
            subjects=subjectRepository.findSubjectsByTeachers_id(teacher1.getId());
            model.addAttribute("subjects",subjects);
        } else{
            subjects = subjectRepository.findAll();
            model.addAttribute("subjects",subjectRepository.findAll());
        }
        Student s = studentRepository.getById(id);
        List<Mark> marks = markRepository.findAllByStudent(s);
        model.addAttribute("student", s);
        model.addAttribute("marks", marks);
        List<Integer> numberOfMarks = new ArrayList<>();
        for(Subject ss : subjects){
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
        List<Mark> marks = markRepository.findAllByStudent(student);
        markRepository.deleteAll(marks);
        studentRepository.delete(student);
        return "redirect:/class/studentlist/"+request.getSession().getAttribute("classId");
    }

    @GetMapping("/users/{id}")
    public String users(Model model, @PathVariable long id){
        model.addAttribute("users",userRepository.findUsersByStudents_Id(id));
        model.addAttribute("student",studentRepository.getById(id));
        return "student/users";
    }
}