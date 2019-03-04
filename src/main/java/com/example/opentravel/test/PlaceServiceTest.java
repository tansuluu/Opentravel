package com.example.opentravel.test;


import com.example.opentravel.model.Place;
import com.example.opentravel.repository.PlaceRepository;
import com.example.opentravel.service.PlaceService;
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
public class PlaceServiceTest {

    @Mock
    PlaceRepository placeRepositoryMock;

    @InjectMocks
    PlaceService placeService;

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
        Place place=new Place();
        long id=1;
        place.setId(1);
        when(placeRepositoryMock.findById(id)).thenReturn(place);
        assertEquals(place,placeService.findById(id));
    }

    @Test
    public void findByUsarname(){
        ArrayList<Place> list=new ArrayList<>();
        Place place=new Place();
        String name="Islam";
        place.setUsarname("Islam");
        Place place1=new Place();
        place1.setUsarname("Islam");
        list.add(place);
        list.add(place1);
        when(placeRepositoryMock.findByUsarname(name)).thenReturn(list);
        assertEquals(list,placeService.findByUsarname(name));

    }


}
