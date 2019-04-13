package com.example.opentravel;
import com.example.opentravel.model.*;
import com.example.opentravel.repository.CommentBlogRepository;
import com.example.opentravel.service.CommentBlogService;
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
public class CommentBlogServiceTest {
    @Mock
    CommentBlogRepository commentBlogRepositoryMock;

    @Autowired
    CommentBlogRepository commentBlogRepository;

    @InjectMocks
    CommentBlogService commentBlogService;

    @Before
    public void setUp(){
        System.out.println("Starting CommentBlogService Test Class");
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

    @Test
    public void testFindByIdAndBlog(){
        CommentBlog blog = new CommentBlog();
        Blog blog1 = new Blog();
        long id = 1;
        blog.setId(id);
        when(commentBlogRepositoryMock.findByIdAndBlog(id, blog1)).thenReturn(blog);
        assertEquals(blog,commentBlogRepositoryMock.findByIdAndBlog(id, blog1));
    }

    @Test
    public void testFindByBlog(){
        ArrayList<CommentBlog> list=new ArrayList<>();
        CommentBlog blog=new CommentBlog();
        Blog user1=new Blog();
        String name = "Meder";
        user1.setTitle(name);
        blog.setBlog(user1);
        list.add(blog);
        when(commentBlogRepositoryMock.findByBlog(user1)).thenReturn(list);
        assertEquals(list,commentBlogService.findByBlog(user1));
    }

    @Test
    public void testSave(){
        long id=1;
        User user = new User();
        String text = "Hello World!";
        CommentBlog commentBlog = new CommentBlog();
        commentBlog.setUser(user);
        commentBlog.setComentText(text);
        commentBlog.setId(id);
        when(commentBlogRepositoryMock.save(commentBlog)).thenReturn(commentBlog);
        assertEquals(commentBlog,commentBlogRepositoryMock.save(commentBlog));
    }

    @Test
    public void testDelete(){
        CommentBlog commentBlog = new CommentBlog();
        Blog blog = new Blog();
        long doseId=1;
        commentBlog.setId(doseId);
        // perform the call
        commentBlogService.deleteComment(commentBlog.getId(), blog);
    }


    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
