package com.example.opentravel;

import com.example.opentravel.model.Post;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PostRepository;
import com.example.opentravel.service.PostService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

        @Mock
        PostRepository postRepositoryMock;

        @Autowired
        PostRepository postRepository;

        @InjectMocks
        PostService postService;

        @Before
        public void setUp(){
            System.out.println("Starting PostServiceTest Class");
        }

    @Test
    public void testFindById(){
        Post post=new Post();
        long id=1;
        post.setId(1);
        when(postRepositoryMock.findById(id)).thenReturn(post);
        assertEquals(post,postService.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        Post post=new Post();
        long id=0;
        when(postRepositoryMock.findById(id)).thenReturn(post);
        assertEquals(post,postService.findById(id));
    }

    @Test
        public void testFindByUser(){
            ArrayList<Post> list=new ArrayList<>();
            Post post=new Post();
            User user1=new User();
            String name = "Meder";
            user1.setName(name);
            post.setUser(user1);
            User user=new User();
            user.setName("Meder");
            list.add(post);
            when(postRepositoryMock.findByUser(user)).thenReturn(list);
            assertEquals(list,postService.findByUser(user));
        }

    @Test
    public void testSave(){
        long id=1;
        User user = new User();
        String text = "Hello World!";
        Post post = new Post();
        post.setUser(user);
        post.setPostText(text);
        post.setId(id);
        when(postRepositoryMock.save(post)).thenReturn(post);
        assertEquals(post,postRepositoryMock.save(post));
    }

    @Test
    public void testDelete(){
        Post post = new Post();
        long doseId=1;
        post.setId(doseId);
        // perform the call
        postService.deleteById(post.getId());
    }

    @After
    public void terminate(){
        System.out.println("PostServiceTest class is terminated");
    }

}
