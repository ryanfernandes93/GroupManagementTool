package com.csci5308.grouptool.Signup.Controller;

import com.csci5308.grouptool.Signup.Model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MainController implements WebMvcConfigurer {

    @GetMapping("/")
    public String FrontPage(UserModel userModel){
        return "index";
    }

    @GetMapping("/signup")
    public String showSignup(Model model){
        model.addAttribute("userModel", new UserModel());
        return "signup";
    }
}
