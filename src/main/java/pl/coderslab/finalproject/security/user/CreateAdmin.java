package pl.coderslab.finalproject.security.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.security.UserService;
import pl.coderslab.finalproject.security.role.Role;
import pl.coderslab.finalproject.security.role.RoleRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CreateAdmin {
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    public CreateAdmin(UserService userService, RoleRepository roleRepository, UserRepository userRepository){
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }
    @RequestMapping("/createUser")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleRepository.findByName("ADMIN"));
        user.setRoles(roles);
        userService.saveUser(user);
        userRepository.save(user);
        return "admin";
    }
}
