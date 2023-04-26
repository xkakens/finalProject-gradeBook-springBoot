package pl.coderslab.finalproject.security.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.security.UserService;
import pl.coderslab.finalproject.security.role.Role;
import pl.coderslab.finalproject.security.role.RoleRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserController(UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
    public String add(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        if (userRepository.countAllByUsername(username) > 0) {
            model.addAttribute("notification", "<h2 style=\"color: red;\">Nazwa użytkownika zajęta!</h2>");
            return "user/add";
        }
        String password = request.getParameter("password");
        User user = new User();
        user.setEnabled(1);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
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
}