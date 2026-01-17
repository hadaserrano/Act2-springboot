package com.example.Act2_springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String root(){
       return "La practica ha finalizado correctamente";
    }
}
