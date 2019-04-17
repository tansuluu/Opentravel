package com.example.opentravel.service;
import com.example.opentravel.model.Blog;
import com.example.opentravel.model.CommentBlog;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<Blog> findByAuthor(User user){
        return blogRepository.findByAuthor(user);
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

    public void delete(long id){
       blogRepository.delete(blogRepository.findById(id));
    }

    public void deleteBlog(Blog blog){
       blogRepository.delete(blog);
    }

    public List<Blog> findAllByTitle(String text){
        return blogRepository.findAllByTitle(text);
    }

    public Page<Blog> findAll(Pageable pageable){
        return blogRepository.findAll(pageable);
    }


}
