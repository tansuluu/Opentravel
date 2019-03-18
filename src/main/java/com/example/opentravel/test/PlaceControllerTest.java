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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


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

    @Test
    public void test_new_place(){
        String URI = "/newPlace";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI);
//        MvcResult result = mockPlaceRepo.(requestBuilder).andReturn();

//        assertThat(result).isEqualTo(result.getResponse());
    }
}
