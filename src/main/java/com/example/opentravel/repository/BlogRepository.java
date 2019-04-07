package com.example.opentravel.repository;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    Blog findById(long id);
    List<Blog> getAllByOrderByView();
    List<Blog> findByAuthor(User user);
    List<Blog> findAllByTitle(String text);

    @Override
    Page<Blog> findAll(Pageable pageable);
}