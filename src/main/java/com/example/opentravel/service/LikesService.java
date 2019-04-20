package com.example.opentravel.service;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Likes;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("likesService")
public class LikesService {

    @Autowired
    private LikesRepository likeRepository;

    public Likes save(Likes likes){
        return likeRepository.save(likes);
    }

    public int removeByPlaceAndUser(Place place, User user){
        return likeRepository.removeByPlaceAndUser(place,user);

    }

    public boolean existsByPlaceAndUser(Place place, User user){
        return likeRepository.existsByPlaceAndUser(place,user);
    }

    public int removeByUsernameAndBlogIDd(User user, Blog blog){
        return likeRepository.removeByUserAndBlog(user,blog);

    }

    public boolean existsByBlogAndUser(Blog blog, User user){
        return likeRepository.existsByBlogAndUser(blog, user);
    }
}
