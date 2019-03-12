package com.example.opentravel.service;
import com.example.opentravel.model.Blog;
import com.example.opentravel.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public List<Blog> findByUsername(String username){
        return blogRepository.findBlogByUsername(username);
    }

    public List<Blog> getTop3PlaceByOrderByView(){
        List<Blog> list=blogRepository.getAllByOrderByView();
        List<Blog> listTop=new ArrayList<>();
        listTop.add(list.get(0));
        listTop.add(list.get(1));
        listTop.add(list.get(2));
        return listTop;
    }
    public List<Blog> getAll() {
        return blogRepository.getAllByOrderByView();
    }


}
