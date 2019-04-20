package com.example.opentravel.controller;

import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.LikesService;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Transactional
public class LikesController {

    @Autowired
    private LikesService likeService;

    @Autowired
    PlaceService placeService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hasPutBlog", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> putedLikeBlog(@RequestParam("id") long id, @RequestParam("username") String username) {
        int result =0 ;
        if (likeService.existsByBlogAndUser(blogService.findById(id),userService.findUserByEmail(username))) {
            result = 1;
        }
        return ResponseEntity.ok(result);

    }
}
