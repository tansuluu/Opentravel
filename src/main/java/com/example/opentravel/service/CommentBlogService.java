package com.example.opentravel.service;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.CommentBlog;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.CommentBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service("commentBlogService")
public class CommentBlogService {

    @Autowired
    private CommentBlogRepository commentBlogRepository;

    @Autowired
    private BlogService blogService;

    public List<CommentBlog> findByUser(User user){
        return commentBlogRepository.findByUser(user);
    }

    public CommentBlog findById(long id){
        return commentBlogRepository.findById(id);
    }

    public CommentBlog findByIdAndBlog(long id, Blog blog){
        return commentBlogRepository.findByIdAndBlog(id,blog);
    }

    public List<CommentBlog> findByBlog(Blog blog){
        return commentBlogRepository.findByBlog(blog);
    }

    public CommentBlog save(String text, long id,User user){
        Blog place=blogService.findById(id);
        CommentBlog placeComment=new CommentBlog(text, Calendar.getInstance().getTime(),place,user);
        return commentBlogRepository.save(placeComment);
    }

    public void deleteComment(long id,Blog place){
        commentBlogRepository.delete(findByIdAndBlog(id,place));
    }


    public void updateBlogComment(long id) {
        CommentBlog commentBlog = findById(id);
    }
}
