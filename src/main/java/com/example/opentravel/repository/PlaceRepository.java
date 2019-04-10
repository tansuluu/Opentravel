package com.example.opentravel.repository;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place findById(long id);
    List<Place> getAllByOrderByView();
    List<Place> findByAuthor(User author);
    List<Place> findAllByTitle(String text);

    @Override
    Page<Place> findAll(Pageable pageable);
}