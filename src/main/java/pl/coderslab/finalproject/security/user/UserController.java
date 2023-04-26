package pl.coderslab.finalproject.security.user;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.security.UserService;
import pl.coderslab.finalproject.student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public UserController(UserService userService, UserRepository userRepository, StudentRepository studentRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
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
    public String all(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "user/all";
    }

    @GetMapping("/add")
    public String add(@PathVariable long id, Model model){
        return "user/add";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request, Model model, @Valid @ModelAttribute User checkUser, BindingResult result){
        String username = request.getParameter("username");
        if(userRepository.countAllByUsername(username)>0){
            model.addAttribute("notification","<h2 style=\"color: red;\">Nazwa użytkownika zajęta!</h2>");
            return "user/add";
        }
        if(result.hasErrors()){
            model.addAttribute("path", "/user/add");
            return "wrongData";
        }
        String password = request.getParameter("password");
        User user = new User();
        user.setEnabled(1);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/user/all";
    }
}