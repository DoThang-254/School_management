package com.example.school_management.controller;

import com.example.school_management.model.Account;
import com.example.school_management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@Controller
public class HomeController {
    private AccountService accountService;

    @Autowired
    public HomeController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        return "admin/admin";
    }
    @GetMapping("/managestudent")
    public String manageStudent(Model model){
        List<Account> list = accountService.getAllAccount();
        model.addAttribute("studentlist" , list );
        return "admin/managestudent";
    }

    @GetMapping("/teacher")
    public String teacher(Model model){
        return "teacher/teacher";
    }
    @GetMapping("/accessdenied")
    public String accessdenied(Model model){
        return "auth/accessdenied";
    }


}
