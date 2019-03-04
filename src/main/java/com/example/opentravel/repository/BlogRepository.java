package com.example.opentravel.repository;

import com.example.opentravel.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Blog findById(long id);
    List<Blog> getAllByOrderByView();
    List<Blog> findBlogByUsername(String username);
    List<Blog> findAllByTitle(String text);
}