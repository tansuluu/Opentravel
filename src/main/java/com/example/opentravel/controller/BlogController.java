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
            return "newBlog";
        }
        try {
            blog=storageService.preStore(file1,file2,file3,blog);
            userService.findUserByEmail(principal.getName());
            blog.setUsername(principal.getName());
            blogService.save(blog);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            model.addAttribute("blog", blog);
            model.addAttribute("message","There is already exist such image");
            return "newBlog";
        }

        return "redirect:/userPage?username="+principal.getName();
    }
    @RequestMapping("/blogInfo")
    public String showApplications(Model model, @RequestParam("id")long id, Principal principal){
        Blog blog=blogService.findById(id);
        List<Blog> popular=blogService.getTop3PlaceByOrderByView();
        model.addAttribute("app",blog);
        model.addAttribute("popular",popular);
        return "single-blog";
    }

    @RequestMapping("/deleteApp")
    public String deleteApplications(@RequestParam("id")long id){
        blogService.delete(id);
        return "redirect:/blog";
    }

    @RequestMapping("/blog")
    public String places(Model model){
        List<Blog> list=blogService.getAll();
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/updateBlog")
    public String updatePlace(@RequestParam("id") long id, Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog", blog);
        return "updateBlog";
    }

    @RequestMapping(value = "/updateBlog",method = RequestMethod.POST)
    public String updatePlace(@Valid Blog blog){
        Blog blog1=blogService.findById(blog.getId());
        blog1.setTitle(blog.getTitle());
        blog1.setText(blog.getText());
        blog1.setCategory(blog.getCategory());
        blogService.save(blog1);
        return "redirect:/blogInfo?id="+blog1.getId();
    }

    @RequestMapping("/findBlog")
    public String find2(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }



    @RequestMapping("/findBlog")
    public String find22(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }


    @RequestMapping("/findBlog")
    public String find222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }


    @RequestMapping("/findBlog")
    public String find2222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }


    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }
    @RequestMapping("/findBlog")
    public String find22222(@RequestParam(name = "input",required = true) String input, Model model){
        List<Blog> list=blogService.findAllByTitle(input);
        model.addAttribute("blogs", list);
        return "blog";
    }

}
