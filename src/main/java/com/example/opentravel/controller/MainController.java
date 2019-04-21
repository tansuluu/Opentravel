package com.example.opentravel.controller;

import com.example.opentravel.model.User;
import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.ArrayList;


@Controller
@Transactional
public class MainController {

    @Autowired
    PlaceService placeService;

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @RequestMapping(path = "/{lang}")
    public String index(Model model,@PathVariable("lang") String name){
        System.out.println(name);
        ArrayList list2=userService.getAllByStatus("gid");
        ArrayList list1=userService.getAllByStatus("tourist");
        ArrayList list3=(ArrayList)blogService.getTop3PlaceByOrderByView();
        model.addAttribute("gids", list2);
        model.addAttribute("tourist", list1);
        model.addAttribute("blogs", list3);
        return "home";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";

    }
    @RequestMapping("/aboutRus")
    public String aboutRus(){
        return "aboutRus";

    }
    @RequestMapping("/help")
    public String help(){
        return "help";

    }

    @RequestMapping("/gids")
    public String gid(Model model){
        ArrayList<User> list=userService.getAll();
        model.addAttribute("gids", list);
        return "gids";
    }

    @RequestMapping("/chats")
    public String chats(Principal userPrincipal,Model model){
        if (userPrincipal==null){
            return "redirect:/login";
        }
        model.addAttribute("user",userService);
        return "chat";
    }
}