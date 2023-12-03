package com.gestion_biblio.gestion_biblio.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/test")
public class hello {

    @GetMapping
    public String return_hello(){
        return "hello world";
    };


}
