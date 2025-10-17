package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.dto.DtoInputHechoClientes;
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

    @GetMapping("/hechosPaginados")//por defecto me trae 20 hechos de la primera pagina
    public List<DtoInputHechoClientes> obtenerTodosLosHechos(){
        return this.agregacionService.consumirHechos();
    }

   //@GetMapping("/soloUNO/{id}")
     //   public String obtenerHecho(@PathVariable("id") int idHechoExterno){
       //     return this.agregacionService.hechoXid(idHechoExterno);
        //}

    //    @DeleteMapping("/soloUNo/{id}")
    //    public void eliminarHecho(@PathVariable("id") int idHechoExterno){
    //        this.agregacionService.eliminarHecho(idHechoExterno);
    //    }
    //    @GetMapping("/filtrarColeccion/{handle}")
    //    public String filtrarColeccion(){}
}
