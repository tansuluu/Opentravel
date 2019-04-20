package com.example.opentravel.service;

import com.example.opentravel.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("likesService")
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;
}
