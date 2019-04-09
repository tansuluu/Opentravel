package com.example.opentravel.repository;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.PlaceComment;
import com.example.opentravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceCommentRepository extends JpaRepository<PlaceComment,Long> {

    List<PlaceComment> findByUser(User user);

    PlaceComment findById(long id);

    List<PlaceComment> findByPlace(Place place);

    PlaceComment findByIdAndPlace(long id,Place place);
}
