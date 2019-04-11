package com.example.opentravel;
import com.example.opentravel.model.Blog;
import com.example.opentravel.model.CommentBlog;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.BlogRepository;
import com.example.opentravel.repository.CommentBlogRepository;
import com.example.opentravel.service.BlogService;
import com.example.opentravel.service.CommentBlogService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
@RunWith(MockitoJUnitRunner.class)
public class CommentBlogServiceTest {
    @Mock
    CommentBlogRepository commentBlogRepositoryMock;

    @Autowired
    CommentBlogRepository commentBlogRepository;

    @InjectMocks
    CommentBlogService commentBlogService;

    @Before
    public void setUp(){
        System.out.println("Starting BlogService Test Class");
    }

    @Test
    public void testFindByUser(){
        ArrayList<CommentBlog> list=new ArrayList<>();
        CommentBlog blog=new CommentBlog();
        User user1=new User();
        String name = "Meder";
        user1.setName(name);
        blog.setUser(user1);
        User user=new User();
        user.setName("Meder");
        list.add(blog);
        when(commentBlogRepositoryMock.findByUser(user)).thenReturn(list);
        assertEquals(list,commentBlogService.findByUser(user));
    }

    @Test
    public void testFindById(){
        CommentBlog blog = new CommentBlog();
        long id = 1;
        blog.setId(id);
        when(commentBlogRepositoryMock.findById(id)).thenReturn(blog);
        assertEquals(blog,commentBlogRepositoryMock.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        CommentBlog blog=new CommentBlog();
        long id=0;
        when(commentBlogRepositoryMock.findById(id)).thenReturn(blog);
        assertEquals(blog,commentBlogRepositoryMock.findById(id));
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
