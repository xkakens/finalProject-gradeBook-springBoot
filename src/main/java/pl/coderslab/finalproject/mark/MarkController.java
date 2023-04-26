package pl.coderslab.finalproject.mark;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.student.StudentRepository;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.subject.SubjectRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String addMark(@PathVariable Long studentId, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("studentId", studentId);
        model.addAttribute("studentId", session.getAttribute("studentId"));
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "mark/add";
    }

    @PostMapping("/add/{id}")
    public String addMark(@PathVariable Long id, HttpServletRequest request, Model model, @Valid @ModelAttribute Mark checkMark,
                          BindingResult result) {
        HttpSession session = request.getSession();
        if(result.hasErrors()){
            model.addAttribute("path", "/mark/add/" + id);
            return "wrongData";
        }
        Mark mark = new Mark();
        mark.setValue(Integer.parseInt(request.getParameter("value")));
        mark.setImportance(Integer.parseInt(request.getParameter("importance")));
        if(!request.getParameter("description").equals("")) {
            mark.setDescription(request.getParameter("description"));
        }
        mark.setStudent(studentRepository.getById(Long.parseLong(session.getAttribute("studentId").toString())));
        mark.setSubject(subjectRepository.getById(Long.valueOf(request.getParameter("subjectName"))));
        markRepository.save(mark);
        model.addAttribute("student", studentRepository.getById(Long.parseLong(session.getAttribute("studentId").toString())));
        List<Mark> marks = markRepository.findAllByStudent(studentRepository.getById(Long.parseLong(session.getAttribute("studentId").toString())));
        model.addAttribute("marks", marks);
        return "redirect:/student/marks/" + session.getAttribute("studentId");
    }
    //bartek

    @GetMapping("/delete/{markId}")
    public String delete(@PathVariable long markId, Model model) {
        Mark mark = markRepository.getById(markId);
        model.addAttribute("mark", mark);
        return "mark/delete";
    }

    @PostMapping("/delete/{markId}")
    public String delete(@PathVariable long markId) {
        Long studentId = markRepository.getById(markId).getStudent().getId();
        markRepository.deleteById(markId);
        return "redirect:/student/marks/" + studentId;
    }
    @GetMapping("/update/{id}")
    public String updateMark(@PathVariable Long id, Model model) {
        model.addAttribute("mark", markRepository.getById(id));
        return "mark/update";
    }

    @PostMapping("/update/{id}")
    public String updateMark(HttpServletRequest request, @PathVariable Long id,
                             @Valid @ModelAttribute Mark checkMark, BindingResult result, Model model) {
        HttpSession session = request.getSession();
        if(result.hasErrors()){
            model.addAttribute("path", "/mark/update/" + id);
            return "wrongData";
        }
        Mark m = markRepository.getById(id);
        m.setValue(Integer.parseInt(request.getParameter("value")));
        m.setImportance(Integer.parseInt(request.getParameter("importance")));
        m.setDescription(request.getParameter("description"));
        markRepository.save(m);
        return "redirect:/student/marks/" + session.getAttribute("studentId");
    }


}
