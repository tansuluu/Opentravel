package com.example.opentravel;

import com.example.opentravel.model.*;
import com.example.opentravel.repository.PlaceCommentRepository;
import com.example.opentravel.service.PlaceCommentService;
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
public class PlaceCommentServiceTest {

    @Mock
    PlaceCommentRepository placeCommentRepositoryMock;

    @Autowired
    PlaceCommentRepository placeCommentRepository;

    @InjectMocks
    PlaceCommentService placeCommentService;

    @Before
    public void setUp(){
        System.out.println("Starting PlaceCommentServiceTest Class");
    }

    @Test
    public void testFindByUser(){
        ArrayList<PlaceComment> list=new ArrayList<>();
        PlaceComment placeComment=new PlaceComment();
        User user1=new User();
        String name = "Meder";
        user1.setName(name);
        placeComment.setUser(user1);
        User user=new User();
        user.setName("Meder");
        list.add(placeComment);
        when(placeCommentRepositoryMock.findByUser(user)).thenReturn(list);
        assertEquals(list,placeCommentService.findByUser(user));
    }

    @Test
    public void testFindById(){
        PlaceComment placeComment = new PlaceComment();
        long id = 1;
        placeComment.setId(id);
        when(placeCommentRepositoryMock.findById(id)).thenReturn(placeComment);
        assertEquals(placeComment,placeCommentRepositoryMock.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        PlaceComment placeComment=new PlaceComment();
        long id=0;
        when(placeCommentRepositoryMock.findById(id)).thenReturn(placeComment);
        assertEquals(placeComment,placeCommentRepositoryMock.findById(id));
    }

    @Test
    public void testFindByIdAndPlace(){
        PlaceComment placeComment = new PlaceComment();
        Place place = new Place();
        long id = 1;
        place.setId(id);
        when(placeCommentRepositoryMock.findByIdAndPlace(id, place)).thenReturn(placeComment);
        assertEquals(placeComment,placeCommentRepositoryMock.findByIdAndPlace(id, place));
    }

    @Test
    public void testFindByPlace(){
        ArrayList<PlaceComment> list=new ArrayList<>();
        PlaceComment placeComment=new PlaceComment();
        Place place=new Place();
        String name = "Meder";
        place.setTitle(name);
        placeComment.setPlace(place);
        list.add(placeComment);
        when(placeCommentRepositoryMock.findByPlace(place)).thenReturn(list);
        assertEquals(list,placeCommentService.findByPlace(place));
    }

    @Test
    public void testSave(){
        long id=1;
        User user = new User();
        String text = "Hello World!";
        PlaceComment placeComment = new PlaceComment();
        placeComment.setUser(user);
        placeComment.setComentText(text);
        placeComment.setId(id);
        when(placeCommentRepositoryMock.save(placeComment)).thenReturn(placeComment);
        assertEquals(placeComment,placeCommentRepositoryMock.save(placeComment));
    }

    @Test
    public void testDelete(){
        PlaceComment placeComment = new PlaceComment();
        Place place = new Place();
        long doseId=1;
        placeComment.setId(doseId);
        // perform the call
        placeCommentService.deleteComment(placeComment.getId(), place);
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
