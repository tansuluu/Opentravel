package com.example.opentravel.service;


import com.example.opentravel.model.ContactMessage;
import com.example.opentravel.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactMessageService")
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage findById(long id){
        return contactMessageRepository.findById(id);
    }

    public List<ContactMessage> getAll(){
        return contactMessageRepository.findAll();
    }
}
