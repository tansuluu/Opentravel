package com.example.opentravel;

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
import java.util.Date;
import java.util.List;

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
        Blog blog=new Blog();
        long id=0;
        when(blogRepositoryMock.findById(id)).thenReturn(blog);
        assertEquals(blog,blogServiceTest.findById(id));
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
        when(blogRepositoryMock.findAllByTitle(title)).thenReturn(list);
        assertEquals(list,blogServiceTest.findAllByTitle(title));
    }

    @Test
    public void findByTitleTest_whennull(){
        ArrayList<Blog> list=new ArrayList<>();
        Blog blog=new Blog();
        String title = null;
        blog.setTitle(title);
        Blog blog1=new Blog();
        blog1.setTitle(title);
        list.add(blog);
        list.add(blog1);
        when(blogRepositoryMock.findAllByTitle(title)).thenReturn(list);
        assertEquals(list,blogServiceTest.findAllByTitle(title));
    }

    @Test
    public void findByTitleTest_whenNoSuchBlog(){
        ArrayList<Blog> list1=new ArrayList<>();
        when(blogRepositoryMock.findAllByTitle("Talas")).thenReturn(list1);
        assertEquals(list1,blogServiceTest.findAllByTitle("Talas"));
    }


    @Test
    public void testGetAllBlogs() {

        Blog mockTicket1 = new Blog();
        mockTicket1.setId(1);
        mockTicket1.setTitle("Martin Bingel");
        mockTicket1.setCategory("Kolkata");
        mockTicket1.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket1.setPhoto1("emg/meder.png");
        mockTicket1.setPhoto2("emg/meder.png");
        mockTicket1.setPhoto3("emg/meder.png");
        mockTicket1.setDate(new Date());
        mockTicket1.setView(1);
        mockTicket1.setLikes(1);
        mockTicket1.setSmallText("is the best of the best");

        Blog mockTicket2 = new Blog();
        mockTicket2.setId(2);
        mockTicket2.setTitle("Martin Bingel");
        mockTicket2.setCategory("Kolkata dsc");
        mockTicket2.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket2.setPhoto1("emg/meder.png");
        mockTicket2.setPhoto2("emg/meder.png");
        mockTicket2.setPhoto3("emg/meder.png");
        mockTicket2.setDate(new Date());
        mockTicket2.setView(1);
        mockTicket2.setLikes(1);
        mockTicket2.setSmallText("is the best of the best");

        List<Blog> ticketList = new ArrayList<>();
        ticketList.add(mockTicket1);
        ticketList.add(mockTicket2);
        when(blogRepositoryMock.getAllByOrderByView()).thenReturn(ticketList);
        assertEquals(ticketList, blogServiceTest.getAll());
    }
    @Test
    public void getTop3PlaceByOrderByViewTest(){
        Blog mockTicket1 = new Blog();
        mockTicket1.setId(1);
        mockTicket1.setTitle("Martin Bingel");
        mockTicket1.setCategory("Kolkata");
        mockTicket1.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket1.setPhoto1("emg/meder.png");
        mockTicket1.setPhoto2("emg/meder.png");
        mockTicket1.setPhoto3("emg/meder.png");
        mockTicket1.setDate(new Date());
        mockTicket1.setView(1);
        mockTicket1.setLikes(9);
        mockTicket1.setSmallText("is the best of the best");

        Blog mockTicket2 = new Blog();
        mockTicket2.setId(2);
        mockTicket2.setTitle("Martin Bingel");
        mockTicket2.setCategory("Kolkata dsc");
        mockTicket2.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket2.setPhoto1("emg/meder.png");
        mockTicket2.setPhoto2("emg/meder.png");
        mockTicket2.setPhoto3("emg/meder.png");
        mockTicket2.setDate(new Date());
        mockTicket2.setView(1);
        mockTicket2.setLikes(1);
        mockTicket2.setSmallText("is the best of the best");
        Blog mockTicket3 = new Blog();
        mockTicket3.setId(3);
        mockTicket3.setTitle("Martin Bingel");
        mockTicket3.setCategory("Kolkata dsc");
        mockTicket3.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket3.setPhoto1("emg/meder.png");
        mockTicket3.setPhoto2("emg/meder.png");
        mockTicket3.setPhoto3("emg/meder.png");
        mockTicket3.setDate(new Date());
        mockTicket3.setView(5);
        mockTicket3.setLikes(1);
        mockTicket3.setSmallText("is the best of the best");

        List<Blog> ticketList = new ArrayList<>();
        ticketList.add(mockTicket1);
        ticketList.add(mockTicket2);
        ticketList.add(mockTicket3);
        when(blogRepositoryMock.getAllByOrderByView()).thenReturn(ticketList);
        assertEquals(ticketList, blogServiceTest.getTop3PlaceByOrderByView());
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
