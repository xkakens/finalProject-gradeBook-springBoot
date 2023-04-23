package pl.coderslab.finalproject.subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherRepository;

import java.util.List;
//bartek
@RequestMapping("/subject")
@Controller
public class SubjectController {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    public SubjectController(SubjectRepository subjectRepository, TeacherRepository teacherRepository){
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/all")
    public String allSubjects(Model model){
        List<Subject> subjectList = subjectRepository.findAll();
        model.addAttribute("subjects",subjectList);
        return "subject/all";
    }

    @GetMapping("/add")
    public String addSubject(Model model){
        List<Teacher> teacherList = teacherRepository.findAll();
        model.addAttribute("teachers",teacherList);
        return "subject/add";
    }

    @PostMapping("/add")
    public String addSubject(){
        return "subject/all";
    }
}
