package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;
import ar.utn.ba.ddsi.grupo24.services.IAgregacionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AgregacionController {

    private final IAgregacionService agregacionService;

    public AgregacionController(IAgregacionService agregacionService) {
        this.agregacionService = agregacionService;
    }

    //por ahora mi unica fuente sera Proxy.
    @GetMapping("/todo")
    public String obtenerTodosLosHechos(@RequestParam int page,@RequestParam int perPage){
        return this.agregacionService.consumirHechos(page ,perPage);
    }//se testeo solo el primero

    @GetMapping("/soloUNO/{id}")
    public String obtenerHecho(@PathVariable("id") int idHechoExterno){
        return this.agregacionService.hechoXid(idHechoExterno);
    }
    @DeleteMapping("/soloUNo/{id}")
    public void eliminarHecho(@PathVariable("id") int idHechoExterno){
        this.agregacionService.eliminarHecho(idHechoExterno);
    }
}
