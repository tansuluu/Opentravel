package com.example.opentravel.repository;

import com.example.opentravel.model.Post;
import com.example.opentravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    public Post findById(long id);

    public List<Post> findByUser(User user);

}
