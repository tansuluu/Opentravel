package com.example.opentravel.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class AuthController {

    @RequestMapping("/")
    public String index() {
        return "We have started!";
    }
}
