package com.example.opentravel.controller;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.StorageService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class UserController {


    @Autowired
    private StorageService storageService;

    @Autowired
    UserService userService;

    @Autowired
    PlaceService placeService;

    @RequestMapping("/find")
    public String find(@RequestParam(name = "input",required = true) String input, Model model){
        ArrayList<User> list=userService.findByName(input);
        model.addAttribute("gids", list);
        return "gids";
    }
    @RequestMapping("/userPage")
    public String showUser(Model model, @RequestParam("username")String email){
        User user=userService.findUserByEmail(email);
        List<Place> list=placeService.findByUsarname(email);
        model.addAttribute("places",list);
        model.addAttribute("user",user);
        return "profile";
    }
    @GetMapping("/image/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        String mimeType = "";
        try {
            mimeType = Files.probeContentType(file.getFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
    @GetMapping("/up-avatar/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getAvatar(@PathVariable String filename) {
        Resource file = storageService.loadAvatar(filename);
        String mimeType = "";
        try {
            mimeType = Files.probeContentType(file.getFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getFilename());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + file.getFilename() + "\"")
                .body(file);
    }


}