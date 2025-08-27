package com.example.school_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        return "admin/admin";
    }
    @GetMapping("/managestudent")
    public String manageStudent(Model model){return "admin/managestudent";}

    @GetMapping("/teacher")
    public String teacher(Model model){
        return "teacher/teacher";
    }
    @GetMapping("/accessdenied")
    public String accessdenied(Model model){
        return "accessdenied";
    }


}
