package com.example.opentravel.controller;

import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Transactional
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    PlaceService placeService;

    @Autowired
    BlogService blogService;
    @RequestMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users",userService.getAll());
        return "adminUsers";
    }

    @RequestMapping("/adminPlaces")
    public String adminPlaces(Model model){
        model.addAttribute("users",userService.getAll());
        return "adminUsers";
    }
}