package pl.coderslab.finalproject.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.schoolClass.SchoolClass;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//bartek
@RequestMapping("/teacher")
@Controller
public class TeacherController {
    private final TeacherRepository teacherRepository;
    public TeacherController(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    @GetMapping("/all")
    public String allTeachers(Model model){
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teacher/all";
    }

    @GetMapping("/add")
    public String addTeacher(){
        return "teacher/add";
    }

    @PostMapping("/add")
    public String addTeacher(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacherRepository.save(teacher);
        return "redirect:/teacher/all";
    }
}
