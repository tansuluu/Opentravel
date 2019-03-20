package com.example.opentravel.test;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PlaceRepository;
import com.example.opentravel.repository.UserRepository;
import com.example.opentravel.service.PlaceService;
import com.example.opentravel.service.UserService;
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

public
@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {
    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

    @Before
    public void setUp(){
        System.out.println("Starting PlaceServiceTest class!");
    }

    @After
    public void terminate(){
        System.out.println("PlaceServiceTest class is terminated");
    }

    @Test
    public void testFindById(){
        User user=new User();
        int id=1;
        user.setId(1);
        when(userRepositoryMock.findById(id)).thenReturn(user);
        assertEquals(user,userService.findUserById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        User user=new User();
        int id=0;
        when(userRepositoryMock.findById(id)).thenReturn(user);
        assertEquals(user,userService.findUserById(id));
    }

    @Test
    public void findByEmail(){
        ArrayList<User> list=new ArrayList<>();
        User user=new User();
        String name="mederbek@gmail.com";
        user.setName(name);
        User user1=new User();
        user1.setName(name);
        list.add(user);
        list.add(user1);
        when(userRepositoryMock.findByEmail(name)).thenReturn(user);
        assertEquals(user,userService.findUserByEmail(name));
    }
    @Test
    public void findByUsarnameNameisEmpty(){
        ArrayList<User> list=new ArrayList<>();
        User user=new User();
        String name="";
        user.setName(name);
        User user1=new User();
        user1.setName(name);
        list.add(user);
        list.add(user1);
        when(userRepositoryMock.findAllByName(name)).thenReturn(list);
        assertEquals(list,userService.findByName(name));
    }
    @Test
    public void findByUsarnameNameIsNull(){
        ArrayList<User> list=new ArrayList<>();
        String name=null;
        when(userRepositoryMock.findAllByName(name)).thenReturn(list);
        assertEquals(list,userService.findByName(name));
    }

    @Test
    public void findByUsarnameNoSuchUser(){
        ArrayList<User> list=new ArrayList<>();
        String name="Mirbek";
        when(userRepositoryMock.findAllByName(name)).thenReturn(list);
        assertEquals(list,userService.findByName(name));
    }

    @Test
    public void saveNewPas(){
        User user = new User();
        user.setName("meder");
        String pass = "tmp";
        user.setPassword(pass);
        //when(userRepositoryMock.findByEmail("meder")).thenReturn(user);
        assertEquals(pass,user.getPassword());
    }

    @Test
    public void testFindByToken(){
        User user=new User();
        String token = "tok1";
        user.setToken(token);
        when(userRepositoryMock.findByToken(token)).thenReturn(user);
        assertEquals(user,userService.findByToken(token));
    }

    @Test
    public void testGetAllByStatus(){
        User user = new User();
        String status = "stat";
        ArrayList<User> list=new ArrayList<>();
        String name="mederbek@gmail.com";
        user.setName(name);
        User user1=new User();
        User user2= new User();
        user2.setName(name);
        user1.setName(name);
        list.add(user);
        list.add(user1);
        list.add(user2);
        when(userRepositoryMock.getAllByStatus(status)).thenReturn(list);
        assertEquals(list,userService.getAllByStatus(status));
    }
}
