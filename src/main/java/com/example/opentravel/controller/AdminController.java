package com.example.opentravel.controller;

import com.example.opentravel.model.CommentBlog;
import com.example.opentravel.model.ContactMessage;
import com.example.opentravel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private EmailService emailService;

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

    @RequestMapping("/deleteContact")
    public String deleteContact(@RequestParam("id")long id){
        contactMessageService.delete(id);
        return "redirect:/adminContacts";
    }

    @RequestMapping(value="/reply",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> reply(@RequestParam("id") long id){
        return ResponseEntity.ok(contactMessageService.findById(id));
    }

    @RequestMapping(value="/replySend",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> replySend(@RequestParam("id") long id, @RequestParam("text") String text, @RequestParam("subject")
                                    String subject, @RequestParam("email") String email, HttpServletRequest request){
        contactMessageService.sendReply(id,text,subject,email,request);
        return ResponseEntity.ok(1);
    }

}