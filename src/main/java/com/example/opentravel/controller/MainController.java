package com.example.opentravel.controller;

import com.example.opentravel.model.User;
import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/")
    public String index(Model model){
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
    public String chats(Model model){
        return "chats";
    }
}