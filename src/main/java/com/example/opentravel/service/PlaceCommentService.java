package com.example.opentravel.service;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.PlaceComment;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PlaceCommentRepository;
import com.example.opentravel.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlaceCommentService")
public class PlaceCommentService {

    @Autowired
    private PlaceCommentRepository placeCommentRepository;

    public List<PlaceComment> findByUser(User user){
        return placeCommentRepository.findByUser(user);
    }

    public PlaceComment findById(long id){
        return placeCommentRepository.findById(id);
    }

    public List<PlaceComment> findByPlace(Place place){
        return placeCommentRepository.findByPlace(place);
    }


}
