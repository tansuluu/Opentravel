package com.example.opentravel.service;
import com.example.opentravel.model.Blog;
import com.example.opentravel.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service("BlogService")
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public Blog findById(long id){
        return blogRepository.findById(id);
    }

    public Blog save(Blog blog){
        blog.setDate(Calendar.getInstance().getTime());
        blog.setSmallText(blog.getText().substring(0,100)+"...");
        return blogRepository.save(blog);
    }

}
