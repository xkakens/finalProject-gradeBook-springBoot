package pl.coderslab.finalproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HelloController {
    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/another")
    public String another(){
        return "schoolclass/all";
    }
}
