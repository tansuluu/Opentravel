package com.example.opentravel.service;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("PlaceService")
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public Place findById(long id){
        return placeRepository.findById(id);
    }


    public Place save(Place place){
        place.setDate(Calendar.getInstance().getTime());
        place.setSmallText(place.getText().substring(0,100)+"...");
        return placeRepository.save(place);
    }

    public List<Place> getTop3PlaceByOrderByView(){
        List<Place> list=placeRepository.getAllByOrderByView();
        List<Place> listTop=new ArrayList<>();
        listTop.add(list.get(0));
        listTop.add(list.get(1));
        listTop.add(list.get(2));
        return listTop;
    }

    public List<Place> findByAuthor(User user){
        return placeRepository.findByAuthor(user);
    }


    public List<Place> getAll(){
        return placeRepository.getAllByOrderByView();
    }

    public ArrayList<Place> findByTitle(String title){
        return (ArrayList)placeRepository.findAllByTitle(title);
    }

    public void delete(long id){
        placeRepository.delete(placeRepository.findById(id));
    }

    public void deletePlace(Place place){
        placeRepository.delete(place);
    }

    public Page<Place> getAll(Pageable pageable){
        return placeRepository.findAll(pageable);
    }
}
