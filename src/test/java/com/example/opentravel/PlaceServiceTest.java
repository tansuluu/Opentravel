package com.example.opentravel;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
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
import java.util.List;

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


    @Test
    public void testFindById(){
        Place place=new Place();
        long id=1;
        place.setId(1);
        when(placeRepositoryMock.findById(id)).thenReturn(place);
        assertEquals(place,placeService.findById(id));
    }

    @Test
    public void testFindByAuthor(){
        ArrayList<Place> list=new ArrayList<>();
        Place place=new Place();
        String title = "Blog1";
        place.setTitle(title);
        User user=new User();
        user.setName("Meder");
        list.add(place);
        when(placeRepositoryMock.findByAuthor(user)).thenReturn(list);
        assertEquals(list,placeService.findByAuthor(user));
    }


    @Test
    public void testFindByIdWhenNoSuchId(){
        Place place=new Place();
        long id=0;
        when(placeRepositoryMock.findById(id)).thenReturn(place);
        assertEquals(place,placeService.findById(id));
    }

    @Test
    public void testGetTop3PlaceByView(){
        //List<Place> list=placeRepositoryMock.getAllByOrderByView();
        List<Place> listTop=new ArrayList<>();
        Place place1 = new Place();
        Place place2 = new Place();
        Place place3 = new Place();
        listTop.add(place1);
        listTop.add(place2);
        listTop.add(place3);

        when(placeRepositoryMock.getAllByOrderByView()).thenReturn(listTop);
        assertEquals(listTop,placeService.getTop3PlaceByOrderByView());
    }

    @Test
    public void getAllPlaces(){
        List<Place> listTop=new ArrayList<>();
        Place place1 = new Place();
        Place place2 = new Place();
        Place place3 = new Place();
        listTop.add(place1);
        listTop.add(place2);
        listTop.add(place3);

        when(placeRepositoryMock.getAllByOrderByView()).thenReturn(listTop);
        assertEquals(listTop, placeService.getAll());
    }

    @Test
    public void testDelete() {
        Place place = new Place();

        int doseId=1;
        place.setId(doseId);
        // perform the call
        placeService.delete(place.getId());

        // verify the mocks
        //assertEquals(blog,blogServiceTest.findById(doseId));

    }

    @After
    public void terminate(){
        System.out.println("PlaceServiceTest class is terminated");
    }


}
