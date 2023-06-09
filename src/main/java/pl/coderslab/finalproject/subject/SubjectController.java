package pl.coderslab.finalproject.subject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.mark.Mark;
import pl.coderslab.finalproject.mark.MarkRepository;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.schoolClass.SchoolClassRepository;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.teacher.TeacherRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
//bartek
@RequestMapping("/subject")
@Controller
public class SubjectController {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final MarkRepository markRepository;
    private final SchoolClassRepository schoolClassRepository;
    public SubjectController(SubjectRepository subjectRepository, TeacherRepository teacherRepository, MarkRepository markRepository, SchoolClassRepository schoolClassRepository){
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.markRepository = markRepository;
        this.schoolClassRepository = schoolClassRepository;
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
    public String addSubject(HttpServletRequest request, Model model,
                             @Valid @ModelAttribute Subject checkSubject, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("path", "/subject/path");
            return "wrongData";
        }
        List<Teacher> teachers = new ArrayList<>();
        for(int i = 1; true; i++){
            String x = request.getParameter("teacher" + i);
            if(x == null){
                break;
            } else {
                Teacher teacher = teacherRepository.findTeacherById(Long.parseLong(x));
                teachers.add(teacher);
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
    public String manage(@PathVariable Long id, HttpServletRequest request,
                         @Valid @ModelAttribute Subject checkSubject, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("path", "/subject/update/" + id);
            return "wrongData";
        }
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        model.addAttribute("subject",subjectRepository.getById(id));
        List<SchoolClass> schoolClasses = schoolClassRepository.findSchoolClassesBySubjects_id(id);
        if(schoolClasses.size()>0){
            return "subject/removeClassesNotification";
        }
        return "subject/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        List<Mark> relatedMarks = markRepository.findMarksBySubjectId(id);
        for(Mark mark : relatedMarks){
            markRepository.delete(mark);
        }
        subjectRepository.deleteById(id);
        return "redirect:/subject/all";
    }
}
