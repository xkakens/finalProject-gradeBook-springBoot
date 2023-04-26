package pl.coderslab.finalproject.security.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.security.UserService;
import pl.coderslab.finalproject.security.role.Role;
import pl.coderslab.finalproject.security.role.RoleRepository;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final StudentRepository studentRepository;

    public UserController(UserService userService,
                          UserRepository userRepository,
                          RoleRepository roleRepository,
                          StudentRepository studentRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("newUser");
        user.setPassword("password");
        userService.saveUser(user);
        return "admin";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "user/add";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request, Model model, @Valid @ModelAttribute User checkUser, BindingResult result){
        String username = request.getParameter("username");
        if (userRepository.countAllByUsername(username) > 0) {
            model.addAttribute("notification", "<h2 style=\"color: red;\">Nazwa użytkownika zajęta!</h2>");
            return "user/add";
        }
        if(result.hasErrors()){
            model.addAttribute("path", "/user/add");
            return "wrongData";
        }
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id, Model model) {
        User user = userRepository.getById(id);
        model.addAttribute("user", user);
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("roles", roleList);
        Set<Role> ext = user.getRoles();
        model.addAttribute("ext", ext);
        return "user/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable long id, HttpServletRequest request) {
        User user = userRepository.getById(id);
        int c = 0;
        Set<Role> roles = new HashSet<Role>();
        for (Role s : roleRepository.findAll()) {
            String str = request.getParameter("roleName" + c);
            if (str != null) {
                roles.add(roleRepository.findByName(str));
            }
            c++;
        }
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:/user/all";
    }

    @PostMapping("/addstudent/{id}")
    public String addStudent(@PathVariable long id, HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        if(userRepository.countAllByUsername(username) == 0){
            model.addAttribute("notification","<h2 style=\"color: red;\">Taki użytkownik nie istnieje</h2>");
            return "redirect:/student/users/" + id;
        }
        User user = userRepository.findByUsername(username);
        user.getStudents().add(studentRepository.getById(id));
        userRepository.save(user);
        return "redirect:/student/users/" + id;
    }

    @PostMapping("/removestudent/{studentId}/{userId}")
    public String removeStudent(@PathVariable long studentId, @PathVariable long userId){
        User user = userRepository.getById(userId);
        user.getStudents().remove(studentRepository.getById(studentId));
        userRepository.save(user);
        return "redirect:/student/users/" + studentId;
    }
}