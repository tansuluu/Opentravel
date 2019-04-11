package com.example.opentravel.service;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.PlaceComment;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PlaceCommentRepository;
import com.example.opentravel.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service("PlaceCommentService")
public class PlaceCommentService {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceCommentRepository placeCommentRepository;

    public List<PlaceComment> findByUser(User user){
        return placeCommentRepository.findByUser(user);
    }

    public PlaceComment findById(long id){
        return placeCommentRepository.findById(id);
    }

    public PlaceComment findByIdAndPlace(long id,Place place){
        return placeCommentRepository.findByIdAndPlace(id,place);
    }

    public List<PlaceComment> findByPlace(Place place){
        return placeCommentRepository.findByPlace(place);
    }

    public PlaceComment save(String text, long id,User user){
        Place place=placeService.findById(id);
        PlaceComment placeComment=new PlaceComment(text,Calendar.getInstance().getTime(),place,user);
        return placeCommentRepository.save(placeComment);
    }

    public void deleteComment(long id,Place place){
        placeCommentRepository.delete(findByIdAndPlace(id,place));
    }


}
