package com.example.opentravel.service;

import com.example.opentravel.model.Favorite;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favoriteService")
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public boolean existsByPlaceAndUser(Place place, User user){
        return favoriteRepository.existsByPlaceAndUser(place,user);
    }

    public void save(Favorite favorite){
        favoriteRepository.save(favorite);
    }

    public void removeByPlaceAndUser(Place place, User u){
        favoriteRepository.removeByPlaceAndUser(place,u);
    }
}
