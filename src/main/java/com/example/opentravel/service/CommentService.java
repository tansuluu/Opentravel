package com.example.opentravel.service;

import com.example.opentravel.model.Comment;
import com.example.opentravel.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("CommentService")
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment findById(long id){
        return commentRepository.findById(id);
    }


    public Comment save(Comment comment){
        comment.setDateCom(Calendar.getInstance().getTime());
        comment.setComentText(comment.getComentText().substring(0,100)+"...");
        return commentRepository.save(comment);
    }


    public List<Comment> findByUsarname(String username){

        return commentRepository.findByUsarname(username);
    }


    public List<Comment> getAll(){
        return commentRepository.getAll();

    }

    public ArrayList<Comment> findByTitle(String title){
        return (ArrayList)commentRepository.findAllByTitle(title);
    }

    public void delete(long id){
        commentRepository.delete(commentRepository.findById(id));
    }
}
