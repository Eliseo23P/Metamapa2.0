package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.services.IAgregacionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AgregacionController {

    private final IAgregacionService agregacionService;

    public AgregacionController(IAgregacionService agregacionService) {
        this.agregacionService = agregacionService;
    }


    @PostMapping()
    public void crearColeccion(@RequestBody DtoInputColeccion coleccion){

    }
}
