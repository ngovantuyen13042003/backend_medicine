package nvt.medicine_be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/admin")
public class AdminController {
    @RequestMapping("/home")
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
