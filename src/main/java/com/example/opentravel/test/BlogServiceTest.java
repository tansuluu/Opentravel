package com.example.opentravel.test;

import com.example.opentravel.model.Blog;
import com.example.opentravel.repository.BlogRepository;
import com.example.opentravel.service.BlogService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceTest {

    @Mock
    BlogRepository blogRepositoryMock;

    @InjectMocks
    BlogService blogServiceTest;

    @Before
    public void setUp(){
        System.out.println("Starting BlogService Test Class");
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }

    @Test
    public void testFindById(){
        Blog blog = new Blog();
        long id = 1;
        blog.setId(id);
        when(blogRepositoryMock.findById(id)).thenReturn(blog);
        assertEquals(blog,blogRepositoryMock.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        Blog place=new Blog();
        long id=0;
        when(blogRepositoryMock.findById(id)).thenReturn(place);
        assertEquals(place,blogServiceTest.findById(id));
    }

    @Test
    public void findByTitleTest(){
        ArrayList<Blog> list=new ArrayList<>();
        Blog blog=new Blog();
        String title = "Blog1";
        blog.setTitle(title);
        Blog blog1=new Blog();
        blog1.setTitle(title);
        list.add(blog);
        list.add(blog1);
        when(blogRepositoryMock.findBlogByUsername(title)).thenReturn(list);
        assertEquals(list,blogServiceTest.findByUsername(title));
    }

}
