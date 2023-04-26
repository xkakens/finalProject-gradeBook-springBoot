package pl.coderslab.finalproject.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.schoolClass.SchoolClassRepository;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.subject.SubjectRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
//bartek
@RequestMapping("/teacher")
@Controller
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final SchoolClassRepository schoolClassRepository;
    public TeacherController(TeacherRepository teacherRepository, SubjectRepository subjectRepository, SchoolClassRepository schoolClassRepository){
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.schoolClassRepository = schoolClassRepository;
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
    public String addTeacher(HttpServletRequest request, Model model,
                             @Valid @ModelAttribute Teacher checkTeacher, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("path", "/teacher/add");
            return "wrongData";
        }
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacherRepository.save(teacher);
        return "redirect:/teacher/all";
    }

    @GetMapping("/subjectlist/{id}")
    public String subjectList(@PathVariable long id, Model model){
        Teacher teacher = teacherRepository.getById(id);
        model.addAttribute("teacher",teacher);
        model.addAttribute("subjects",subjectRepository.findSubjectsByTeachers_id(teacher.getId()));
        return "teacher/subjectlist";
    }

    //bartek
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        model.addAttribute("id",id);
        model.addAttribute("teacher",teacherRepository.getById(id));
        List<SchoolClass> schoolClasses = schoolClassRepository.findAllByTutor(teacherRepository.getById(id));
        if(schoolClasses.size()>0) {
            return "teacher/removeTutorNotification";
        }
        return "teacher/delete";
    }
    //bartek
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        for(Subject subject : subjectRepository.findSubjectsByTeachers_id(id)){
            subject.getTeachers().remove(teacherRepository.getById(id));
        }
        teacherRepository.deleteById(id);
        return "redirect:/teacher/all";
    }
}
