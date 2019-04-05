package com.example.opentravel.repository;

import com.example.opentravel.model.Place;
import com.example.opentravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllByStatus(String status);
    User findByEmail(String email);
    List<User> getAllByOrderByAboutMe();
    List<User> findAllByName(String name);
    User findByToken(String token);
    User findById(int id);
}