package com.example.opentravel.service;

import com.example.opentravel.model.PlaceComment;
import com.example.opentravel.model.Post;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service("PostService")
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public Post findById(long id){
        return postRepository.findById(id);
    }

    public List<Post> findByUser(User user){
        return postRepository.findByUser(user);
    }

    public Post save(String writerName, String Username, String text){
        Post post=new Post(text,Calendar.getInstance().getTime(),userService.findUserByEmail(Username),userService.findUserByEmail(writerName));
        post.setDateCom(Calendar.getInstance().getTime());
        return postRepository.save(post);
    }

    public void deleteById(long id){
        postRepository.delete(findById(id));
    }

    public void updatePost(long id,String  text) {
        Post post = findById(id);
        post.setPostText(text);
        postRepository.save(post);
    }
}
