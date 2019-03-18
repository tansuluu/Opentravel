package com.example.opentravel.controller;

import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
public class AdminController {

    @Autowired
    private UserService userService;


    @RequestMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users",userService.getAll());
        return "users";
    }
}