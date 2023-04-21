package pl.coderslab.finalproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/mainPage")
    public String homePage(){
        return "mainPage";
    }
}
