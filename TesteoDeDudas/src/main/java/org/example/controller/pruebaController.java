package org.example.controller;

import org.example.dto.dtoInput.DtoPrueba;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pruebaController {

    @PostMapping("/test")
    public void test(@RequestBody DtoPrueba dtoPrueba) {
        System.out.println("Nombre: " + dtoPrueba.getNombre());
        System.out.println("Email: " + dtoPrueba.getEmail());
        System.out.println("Calle: " + dtoPrueba.getDireccion().getCalle());

    }
}
