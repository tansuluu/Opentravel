package com.example.opentravel.repository;

import com.example.opentravel.model.Favorite;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

    boolean existsByPlaceAndUser(Place place, User user);

    int removeByPlaceAndUser(Place place, User u);
}
