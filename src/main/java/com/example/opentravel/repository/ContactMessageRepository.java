package com.example.opentravel.repository;

import com.example.opentravel.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactMessageRepository extends JpaRepository<ContactMessage,Long> {

    public ContactMessage findById(long id);

}
