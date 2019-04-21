package com.example.opentravel.service;

import com.example.opentravel.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favoriteService")
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;


}
