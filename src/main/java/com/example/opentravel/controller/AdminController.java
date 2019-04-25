package com.example.opentravel.controller;

import com.example.opentravel.model.ContactMessage;
import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.ContactMessageService;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @Autowired
    private ContactMessageService contactMessageService;

    @RequestMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users",userService.getAll());
        return "adminUsers";
    }

    @RequestMapping("/adminPlaces")
    public String adminPlaces(Model model){
        model.addAttribute("places",placeService.getAll());
        return "adminPlaces";
    }

    @RequestMapping("/adminBlogs")
    public String adminBlogs(Model model){
        model.addAttribute("blogs",blogService.getAll());
        return "adminBlogs";
    }

    @RequestMapping("/adminContacts")
    public String adminContacts(Model model){
        model.addAttribute("contacts",contactMessageService.getAll());
        return "adminContact";
    }

    @RequestMapping(value = "/contactMessage",method = RequestMethod.POST)
    public String contactMessage(Model model, @ModelAttribute("contactMessage")@Valid ContactMessage contactMessage, BindingResult result){
        if (result.hasErrors()) {
            model.addAttribute("contactMessage", contactMessage);
            System.out.println("Error in contact message");
            return "about";
        }
        contactMessageService.save(contactMessage);
        model.addAttribute("test","Thank you for your message, we will message you around 2 hours!");
        model.addAttribute("contactMessage", new ContactMessage());
        return "about";
    }


}