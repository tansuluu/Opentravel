package com.example.opentravel.repository;

import com.example.opentravel.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findById(long id);
    Comment findByUsername(String name);
    List<Comment> findByUsarname(String username);
    List<Comment> findAllByTitle(String text);

    List<Comment> getAll();
}