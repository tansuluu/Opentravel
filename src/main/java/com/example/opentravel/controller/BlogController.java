package com.example.opentravel.controller;

import com.example.opentravel.model.*;
import com.example.opentravel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Transactional
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    StorageService storageService;

    @Autowired
    UserService userService;

    @Autowired
    private CommentBlogService commentBlogService;

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
    @RequestMapping("/blogInfo")
    public String showApplications(Model model, @RequestParam("id")long id, Principal principal){
        Blog blog=blogService.findById(id);
        List<Blog> popular=blogService.getTop3PlaceByOrderByView();
        List<CommentBlog> commentBlogs=commentBlogService.findByBlog(blogService.findById(id));
        model.addAttribute("app",blog);
        model.addAttribute("popular",popular);
        model.addAttribute("comments",commentBlogs);
        return "single-blog";
    }

    @RequestMapping("/deleteApp")
    public String deleteApplications(@RequestParam("id")long id){
        blogService.delete(id);
        return "redirect:/blog";
    }

    @RequestMapping("/blog")
    public String places(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
        PageRequest pageRequest=PageRequest.of(page-1,6);
        Page<Blog> adminPage=blogService.findAll(pageRequest);
        int total=adminPage.getTotalPages();
        if(total>0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,total).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("blogs",adminPage.getContent());
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

    @RequestMapping(value = "/newBlogComment",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> newBlogComment(@RequestParam("comment") String text, @RequestParam("blogId") long id, Principal principal){
        CommentBlog commentBlog=commentBlogService.save(text,id,userService.findUserByEmail(principal.getName()));
        return ResponseEntity.ok(commentBlog);
    }

    @RequestMapping("/deleteBlogComment")
    public String deleteBlogComment(@RequestParam("id") long id, @RequestParam("blogId") long blogId){
        commentBlogService.deleteComment(id,blogService.findById(blogId));
        return "redirect:/blogInfo?id="+blogId+"#comm1";
    }

    @RequestMapping(value="/updateBlogComment",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> updateBlogComment(@RequestParam("blogId") long blogId){
        CommentBlog commentBlog=commentBlogService.findById(blogId);
        return ResponseEntity.ok(commentBlog);
    }

}
