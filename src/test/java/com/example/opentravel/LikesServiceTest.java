package com.example.opentravel;

import com.example.opentravel.model.*;
import com.example.opentravel.repository.LikesRepository;
import com.example.opentravel.service.LikesService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LikesServiceTest {

    @Mock
    LikesRepository likesRepositoryMock;

    @Autowired
    LikesRepository likesRepository;

    @InjectMocks
    LikesService likesService;

    @Before
    public void setUp(){
        System.out.println("Starting LikesServiceTest Class");
    }

    @Test
    public void testSave(){
        long id=1;
        Likes likes = new Likes();
        likes.setId(id);
        when(likesRepositoryMock.save(likes)).thenReturn(likes);
        assertEquals(likes,likesRepositoryMock.save(likes));
    }

    @Test
    public void testRemoveByPlaceAndUser(){
        Likes likes = new Likes();
        User user = new User();
        Place place = new Place();
        likes.setUser(user);
        likes.setPlace(place);
        likesRepositoryMock.removeByPlaceAndUser(place,user);
    }

    @Test
    public void testExistsByPlaceAndUser(){
        Likes likes = new Likes();
        User user = new User();
        Place place = new Place();
        likes.setUser(user);
        likes.setPlace(place);
        when(likesRepositoryMock.existsByPlaceAndUser(place,user)).thenReturn(true);
        assertEquals(true,likesRepositoryMock.existsByPlaceAndUser(place, user));
    }

    @Test
    public void testRemoveByUsernameAndBlogIDd(){
        Likes likes = new Likes();
        User user = new User();
        Blog blog = new Blog();
        likes.setUser(user);
        likes.setBlog(blog);
        likesRepositoryMock.removeByUserAndBlog(user, blog);
    }

    @Test
    public void testExistsByBlogAndUser(){
        Likes likes = new Likes();
        User user = new User();
        Blog blog = new Blog();
        likes.setUser(user);
        likes.setBlog(blog);
        when(likesRepositoryMock.existsByBlogAndUser(blog,user)).thenReturn(true);
        assertEquals(true,likesRepositoryMock.existsByBlogAndUser(blog, user));
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
