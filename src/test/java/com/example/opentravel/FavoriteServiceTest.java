package com.example.opentravel;

import com.example.opentravel.model.Favorite;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.FavoriteRepository;
import com.example.opentravel.service.FavoriteService;
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
public class FavoriteServiceTest {

    @Mock
    FavoriteRepository favoriteRepositoryMock;

    @Autowired
    FavoriteRepository favoriteRepository;

    @InjectMocks
    FavoriteService favoriteService;

    @Before
    public void setUp(){
        System.out.println("Starting FavoriteServiceTest Class");
    }

    @Test
    public void testExistsByPlaceAndUser(){
        Favorite favorite = new Favorite();
        User user = new User();
        Place place = new Place();
        favorite.setUser(user);
        favorite.setPlace(place);
        when(favoriteRepositoryMock.existsByPlaceAndUser(place,user)).thenReturn(true);
        assertEquals(true,favoriteRepositoryMock.existsByPlaceAndUser(place, user));
    }

    @Test
    public void testSave(){
        long id=1;
        Favorite favorite = new Favorite();
        favorite.setId(id);
        when(favoriteRepositoryMock.save(favorite)).thenReturn(favorite);
        assertEquals(favorite,favoriteRepositoryMock.save(favorite));
    }

    @Test
    public void testRemoveByPlaceAndUser(){
        Favorite favorite = new Favorite();
        User user = new User();
        Place place = new Place();
        favorite.setUser(user);
        favorite.setPlace(place);
        favoriteRepositoryMock.removeByPlaceAndUser(place,user);
    }

    @Test
    public void testGetByUser(){
        ArrayList<Favorite> arrayList = new ArrayList<>();
        User user = new User();
        String name = "Meder";
        user.setName(name);
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        arrayList.add(favorite);
        when(favoriteRepositoryMock.getByUser(user)).thenReturn(arrayList);
        assertEquals(arrayList,favoriteService.getByUser(user));
    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}
