package com.example.opentravel.test;

import com.example.opentravel.model.Comment;
import com.example.opentravel.repository.CommentRepository;
import com.example.opentravel.service.CommentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {

    @Mock
    CommentRepository commentRepositoryMock;

    @InjectMocks
    CommentService commentService;

    @Before
    public void setUp(){
        System.out.println("Starting PlaceServiceTest class!");
    }


    @Test
    public void testFindById(){
        Comment comment=new Comment();
        long id=1;
        comment.setId(1);
        when(commentRepositoryMock.findById(id)).thenReturn(comment);
        assertEquals(comment,commentService.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        Comment comment=new Comment();
        long id=0;
        when(commentRepositoryMock.findById(id)).thenReturn(comment);
        assertEquals(comment,commentService.findById(id));
    }

    @Test
    public void findByUsarname(){
        ArrayList<Comment> list=new ArrayList<>();
        Comment comment=new Comment();
        String name="Islam";
        comment.setUsername(name);
        Comment comment1=new Comment();
        comment1.setUsername(name);
        list.add(comment);
        list.add(comment1);
        when(commentRepositoryMock.findByUsarname(name)).thenReturn(list);
        assertEquals(list,commentService.findByUsarname(name));
    }
    @Test
    public void findByUsarnameNameisEmpty(){
        ArrayList<Comment> list=new ArrayList<>();
        Comment comment=new Comment();
        String name="";
        comment.setUsername(name);
        Comment comment1=new Comment();
        comment1.setUsername(name);
        list.add(comment);
        list.add(comment1);
        when(commentRepositoryMock.findByUsarname(name)).thenReturn(list);
        assertEquals(list,commentService.findByUsarname(name));
    }
    @Test
    public void findByUsarnameNameIsNull(){
        ArrayList<Comment> list=new ArrayList<>();
        String name=null;
        when(commentRepositoryMock.findByUsarname(name)).thenReturn(list);
        assertEquals(list,commentService.findByUsarname(name));
    }

    @Test
    public void findByUsarnameNoSuchUser(){
        ArrayList<Comment> list=new ArrayList<>();
        String name="Mirbek";
        when(commentRepositoryMock.findByUsarname(name)).thenReturn(list);
        assertEquals(list,commentService.findByUsarname(name));
    }


    @Test
    public void getAllComments(){
        List<Comment> listTop=new ArrayList<>();
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        listTop.add(comment1);
        listTop.add(comment2);
        listTop.add(comment3);

        when(commentRepositoryMock.getAll()).thenReturn(listTop);
        assertEquals(listTop, commentService.getAll());
    }

    @After
    public void terminate(){
        System.out.println("PlaceServiceTest class is terminated");
    }


}
