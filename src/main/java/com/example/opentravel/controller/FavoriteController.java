package com.example.opentravel.controller;

import com.example.opentravel.model.Favorite;
import com.example.opentravel.model.Likes;
import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.FavoriteService;
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
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    PlaceService placeService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/isFav", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> isFav(@RequestParam("id") long id, @RequestParam("username") String username) {
        int result =0 ;
        if (favoriteService.existsByPlaceAndUser(placeService.findById(id), userService.findUserByEmail(username))) {
            result = 1;
        }
        return ResponseEntity.ok(result);
    }


    @RequestMapping(value = "/addFav", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getLike(@RequestParam("id") long id, @RequestParam("username") String username) {
        favoriteService.save(new Favorite(placeService.findById(id),userService.findUserByEmail(username)));
        return ResponseEntity.ok(1);
    }

    @RequestMapping(value = "/deleteFav", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> deletLike(@RequestParam("id") long id, @RequestParam("username") String username) {
        favoriteService.removeByPlaceAndUser(placeService.findById(id), userService.findUserByEmail(username));
        return ResponseEntity.ok(1);
    }
}
