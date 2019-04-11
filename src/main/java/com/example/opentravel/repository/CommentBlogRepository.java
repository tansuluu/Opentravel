package com.example.opentravel.repository;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.CommentBlog;
import com.example.opentravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentBlogRepository extends JpaRepository<CommentBlog,Long> {

    List<CommentBlog> findByUser(User user);

    CommentBlog findById(long id);

    List<CommentBlog> findByBlog(Blog place);

    CommentBlog findByIdAndBlog(long id,Blog place);
}
