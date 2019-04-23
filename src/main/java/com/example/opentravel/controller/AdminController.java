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
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("places",placeService.getAll());
        return "adminPlaces";
    }

    @RequestMapping("/adminBlogs")
    public String adminBlogs(Model model){
        model.addAttribute("blogs",blogService.getAll());
        return "adminBlogs";
    }

    @RequestMapping(value = "/contactMessage",method = RequestMethod.POST)
    public String contactMessage(Model model){
        model.addAttribute("places",placeService.getAll());
        return "adminPlaces";
    }
    @RequestMapping(value = "/newBlog", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("blog")@Valid Blog blog,
                               BindingResult result, Model model, //
                               Principal principal, @RequestParam(name = "file1", required = false) MultipartFile file1,
                               @RequestParam(name = "file2", required = false)MultipartFile file2, @RequestParam(name = "file3", required = false)MultipartFile file3) {
        if (result.hasErrors()) {
            model.addAttribute("blog", blog);
            System.out.println("Error in adding a new blog");
            return "newBlog";
        }
        try {
            blog=storageService.preStore(file1,file2,file3,blog);
            User user=userService.findUserByEmail(principal.getName());
            blog.setAuthor(user);
            blogService.save(blog);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            model.addAttribute("blog", blog);
            model.addAttribute("message","There is already exist such image");
            return "newBlog";
        }

        return "redirect:/userPage?username="+principal.getName();
    }
}