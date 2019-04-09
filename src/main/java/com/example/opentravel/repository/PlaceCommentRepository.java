package com.example.opentravel.repository;

import com.example.opentravel.model.PlaceComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceCommentRepository extends JpaRepository<PlaceComment,Long> {
}
