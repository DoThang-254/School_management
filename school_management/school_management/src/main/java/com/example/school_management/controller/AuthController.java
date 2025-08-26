package com.example.school_management.controller;

import com.example.school_management.dao.RoleRepository;
import com.example.school_management.model.Account;
import com.example.school_management.model.Role;
import com.example.school_management.service.AccountService;
import com.example.school_management.validation.AccountValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AccountService accountService ;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthController(AccountService accountService, RoleRepository roleRepository) {
        this.accountService = accountService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "auth/login";
    }
    @GetMapping("/404")
    public String show404(Model model){return "auth/404";}
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        AccountValidation av = new AccountValidation();
        model.addAttribute("account" , av);
        return "auth/register" ;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class , stringTrimmerEditor);

    }

    @PostMapping("/handleregister")
    public String handleRegister(@Valid @ModelAttribute("account") AccountValidation av ,
                                 BindingResult binding , Model model){
        if(binding.hasErrors()){
            return "auth/register";
        }

        String username = av.getUsername();
        Account acc = accountService.findByUsername(username);
        if(acc != null) {
            model.addAttribute("account", new AccountValidation());
            model.addAttribute("err" , "account is existed") ;
            return "auth/register";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Account newAcc = new Account();
        newAcc.setUsername(av.getUsername());
        newAcc.setPassword(encoder.encode(av.getPassword()));
        newAcc.setGender(true);
        Role defaultRole = roleRepository.findByRoleName("ROLE_STUDENT");
        newAcc.setRole(defaultRole);
        accountService.save(newAcc);
        return "auth/login";
    }


}
