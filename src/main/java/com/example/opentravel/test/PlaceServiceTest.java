package com.example.opentravel.test;


import com.example.opentravel.model.Place;
import com.example.opentravel.repository.PlaceRepository;
import com.example.opentravel.service.PlaceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceTest {

    @Mock
    PlaceRepository placeRepositoryMock;

    @InjectMocks
    PlaceService placeService;

    @Test
    public void testFindById(){
        Place place=new Place();
        place.setId(1);
        when(placeRepositoryMock.findById(1)).thenReturn(place);
        assertEquals(place,placeService.findById(1));
    }


}
