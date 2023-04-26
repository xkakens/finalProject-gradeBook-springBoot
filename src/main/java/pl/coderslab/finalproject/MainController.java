package pl.coderslab.finalproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(){
        return "redirect:/mainPage";
    }
    @GetMapping("/mainPage")
    public String mainPage2(){
        return "mainPage";
    }
    @GetMapping("/login")
    public String login(){
        return "security/login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "security/logout";
    }
}
