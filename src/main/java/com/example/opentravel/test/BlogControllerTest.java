package com.example.opentravel.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.opentravel.controller.BlogController;
import com.example.opentravel.model.Blog;
import com.example.opentravel.repository.BlogRepository;
import com.example.opentravel.service.BlogService;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class BlogControllerTest {

    @Mock
    private BlogRepository mockMvc;

    @Autowired
    private BlogService blogService;

    @Before
    public void setUp(){
    System.out.println("Starting BlogService Test Class");
}

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
    @Test
    public void testGetAllBlogs() throws Exception {

        Blog mockTicket1 = new Blog();
        mockTicket1.setId(1);
        mockTicket1.setTitle("Martin Bingel");
        mockTicket1.setCategory("Kolkata");
        mockTicket1.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket1.setPhoto1("emg/meder.png");
        mockTicket1.setPhoto2("emg/meder.png");
        mockTicket1.setPhoto3("emg/meder.png");
        mockTicket1.setUsername("meder");
        mockTicket1.setDate(new Date());
        mockTicket1.setView(1);
        mockTicket1.setComNumber(1);
        mockTicket1.setLikes(1);
        mockTicket1.setImage("img/png");
        mockTicket1.setSmallText("is the best of the best");

        Blog mockTicket2 = new Blog();
        mockTicket2.setId(1);
        mockTicket2.setTitle("Martin Bingel");
        mockTicket2.setCategory("Kolkata");
        mockTicket2.setText("Delhi hjdksjdkjdkaskdasjdkjasd");
        mockTicket2.setPhoto1("emg/meder.png");
        mockTicket2.setPhoto2("emg/meder.png");
        mockTicket2.setPhoto3("emg/meder.png");
        mockTicket2.setUsername("meder");
        mockTicket2.setDate(new Date());
        mockTicket2.setView(1);
        mockTicket2.setComNumber(1);
        mockTicket2.setLikes(1);
        mockTicket2.setImage("img/png");
        mockTicket2.setSmallText("is the best of the best");

        List<Blog> ticketList = new ArrayList<>();
        ticketList.add(mockTicket1);
        ticketList.add(mockTicket2);

//        Mockito.when(blogService.getAllBlogs()).thenReturn(ticketList);
        Mockito.when(mockMvc.getAll()).thenReturn(ticketList);

        String URI = "/blog";
    }
}