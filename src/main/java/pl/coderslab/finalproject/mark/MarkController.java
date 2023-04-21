package pl.coderslab.finalproject.mark;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.student.StudentRepository;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.subject.SubjectRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mark")
public class MarkController {
    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public MarkController(MarkRepository markRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/add/{studentId}")
    public String addMark(@PathVariable Long studentId, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        session.setAttribute("studentId", studentId);
        model.addAttribute("studentId",session.getAttribute("studentId"));
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "mark/add";
    }
    @PostMapping("/add")
    public String addMark(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Mark mark = new Mark();
        mark.setValue(Integer.parseInt(request.getParameter("value")));
        mark.setImportance(Integer.parseInt(request.getParameter("importance")));
        mark.setDescription(request.getParameter("description"));
        mark.setStudent(studentRepository.getById(Long.parseLong( session.getAttribute("studentId").toString())));
        mark.setSubject(subjectRepository.getById(Long.valueOf(request.getParameter("subjectName"))));
        markRepository.save(mark);
        model.addAttribute("student", studentRepository.getById(Long.parseLong(session.getAttribute("studentId").toString())));
        List<Mark> marks = markRepository.findAllByStudent(studentRepository.getById(Long.parseLong(session.getAttribute("studentId").toString())));
        model.addAttribute("marks", marks);
        return "redirect:/student/marks/" + session.getAttribute("studentId");
    }

    @RequestMapping ("/remove/{markId}")
    public String removeMark(HttpServletRequest request, @PathVariable Long markId){
        HttpSession session = request.getSession();
        markRepository.deleteById(markId);
        return "redirect:/student/marks/" + session.getAttribute("studentId");
    }


}