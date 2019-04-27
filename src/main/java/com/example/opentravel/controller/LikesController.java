package com.example.opentravel.controller;

import com.example.opentravel.model.Likes;
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

import java.security.Principal;


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


    @RequestMapping(value = "/hasPut", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> putedLike(@RequestParam("id") long id, @RequestParam("username") String username) {
        int result =0 ;
        if (likeService.existsByPlaceAndUser(placeService.findById(id), userService.findUserByEmail(username))) {
            result = 1;
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/addLike", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getLike(@RequestParam("id") long id, @RequestParam("username") String username, Principal principal) {
        likeService.save(new Likes(placeService.findById(id),userService.findUserByEmail(username)));
        placeService.updateLikes(id, 1);
        int likes = placeService.findById(id).getLikes();
        return ResponseEntity.ok(likes);
    }

    @RequestMapping(value = "/deleteLike", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> deletLike(@RequestParam("id") long id, @RequestParam("username") String username) {
        likeService.removeByPlaceAndUser(placeService.findById(id), userService.findUserByEmail(username));
        placeService.updateLikes(id, -1);
        int likes = placeService.findById(id).getLikes();
        return ResponseEntity.ok(likes);
    }
}
