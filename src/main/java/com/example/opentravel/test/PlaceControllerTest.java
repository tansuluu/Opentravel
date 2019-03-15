package com.example.opentravel.test;

import com.example.opentravel.repository.BlogRepository;
import com.example.opentravel.repository.PlaceRepository;
import com.example.opentravel.service.BlogService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(MockitoJUnitRunner.class)
public class PlaceControllerTest {

    @Mock
    private PlaceRepository mockPlaceRepo;

    @Autowired
    private BlogService blogService;

    @Before
    public void setUp(){
        System.out.println("Test starting ...");
    }

    @After
    public void terminate(){
        System.out.println("Test terminating ...");
    }

}
