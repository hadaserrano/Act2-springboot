package com.example.Act2_springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EstadoController {

    @GetMapping("/api/estado")
    public Map<String, String> estado() {
        return Map.of(
                "estado",
                "OK",
                "nombre",
                "Act2 Spring Boot",
                "mensaje",
                "La aplicación está funcionando correctamente" );
    }
}