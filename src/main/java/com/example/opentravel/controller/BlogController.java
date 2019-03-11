package com.example.opentravel.controller;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Place;
import com.example.opentravel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    StorageService storageService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/newBlog", method = RequestMethod.GET)
    public String newPlace(Model model) {
        Blog form = new Blog();
        model.addAttribute("blog", form);
        return "newBlog";
    }

    @RequestMapping(value = "/newBlog", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("blog")@Valid Blog blog,
                               BindingResult result, Model model, //
                               Principal principal, @RequestParam(name = "file1", required = false) MultipartFile file1,
                               @RequestParam(name = "file2", required = false)MultipartFile file2, @RequestParam(name = "file3", required = false)MultipartFile file3) {
        if (result.hasErrors()) {
            model.addAttribute("blog", blog);
            System.out.println("errorororor");
            return "newBlog";
        }
        try {
            System.out.println("here");
            blog=storageService.preStore(file1,file2,file3,blog);
            userService.findUserByEmail(principal.getName());
            blog.setUsername(principal.getName());
            blogService.save(blog);
            System.out.println("here2");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            model.addAttribute("blog", blog);
            model.addAttribute("message","There is already exist such image");
            System.out.println("rrrr");
            return "newBlog";
        }

        return "redirect:/userPage?username="+principal.getName();
    }


}
