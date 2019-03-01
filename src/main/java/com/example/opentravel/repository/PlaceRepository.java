package com.example.opentravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place findById(long id);
    List<Place> getAllByOrderByView();
    List<Place> findByUsarname(String username);
    List<Place> findAllByTitle(String text);

}