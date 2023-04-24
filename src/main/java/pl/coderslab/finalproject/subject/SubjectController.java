package pl.coderslab.finalproject.subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public String addSubject(HttpServletRequest request){
        List<Teacher> teachers = new ArrayList<>();
        for(int i = 1; i < 5+1; i++){
            String x = request.getParameter("teacher" + i);
            if(x == null){
                break;
            } else {
                teachers.add(teacherRepository.findTeacherById(Long.parseLong(x)));
            }
        }
        String name = request.getParameter("name");
        Subject subject = new Subject();
        subject.setName(name);
        subject.setTeachers(teachers);
        subjectRepository.save(subject);
        return "redirect:/subject/all";
    }

    @GetMapping("/update/{id}")
    public String manage(@PathVariable long id, Model model){
        Subject subject = subjectRepository.getById(id);
        model.addAttribute("teachers",teacherRepository.findAll());
        model.addAttribute("subject",subject);
        int length = subject.getTeachers().size();
        model.addAttribute("length",length);
        return "subject/update";
    }

    @PostMapping("/update/{id}")
    public String manage(@PathVariable long id, HttpServletRequest request){
        List<Teacher> teachers = new ArrayList<>();
        for(int i = 1; i < 5+1; i++){
            String x = request.getParameter("teacher" + i);
            if(x == null){
                break;
            } else {
                teachers.add(teacherRepository.findTeacherById(Long.parseLong(x)));
            }
        }
        String name = request.getParameter("name");
        Subject subject = subjectRepository.getById(id);
        subject.setTeachers(teachers);
        subject.setName(name);
        subjectRepository.save(subject);
        return "redirect:/subject/all";
    }
}
