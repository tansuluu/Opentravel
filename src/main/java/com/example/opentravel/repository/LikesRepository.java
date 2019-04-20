package com.example.opentravel.repository;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Likes;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {

    int removeByUserAndBlog(User user, Blog blog);

    int removeByPlaceAndUser(Place place, User user);

    boolean existsByBlogAndUser(Blog blog, User user);

    boolean existsByPlaceAndUser(Place place, User user);

}
