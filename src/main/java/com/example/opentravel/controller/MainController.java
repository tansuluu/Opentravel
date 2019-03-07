package com.example.opentravel.controller;

import com.example.opentravel.model.Place;
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
import java.util.List;


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
        ArrayList list= (ArrayList)placeService.getTop3PlaceByOrderByView();
        ArrayList list2=userService.getAllByStatus("gid");
        ArrayList list1=userService.getAllByStatus("tourist");
        model.addAttribute("places",list);
        model.addAttribute("gids", list2);
        model.addAttribute("tourist", list1);
        return "index";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";

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