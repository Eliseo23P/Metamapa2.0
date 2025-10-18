package ar.utn.ba.ddsi.grupo24.controllers;//package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutputColeccion;
import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.entities.coleccion.Coleccion;
import ar.utn.ba.ddsi.grupo24.services.IAgregacionService;
import ar.utn.ba.ddsi.grupo24.services.IColeccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ColeccionController {

    private final IColeccionService coleccionService;

    public ColeccionController(IColeccionService coleccionService) {
        this.coleccionService = coleccionService;
    }

    //Como persona visualizadora, deseo navegar todos los hechos disponibles de una colección.
    //@GetMapping
    //public DtoOutputColeccion obtenerColeccion(@PathVariable String handle){
     //   return this.coleccionService.obtenerColeccion(handle);
    //}
    //Como persona visualizadora, deseo navegar los hechos disponibles de una colección, aplicando filtros
    //@PostMapping
    //public DtoOutputColeccion filtrarColeccion(@PathVariable String handle , DtoValorFiltro filtros){
    //    return this.coleccionService.filtrar(handle,filtros);
    //}

    //Como persona administradora, deseo crear una colección
    @PostMapping("/crear")
    public ResponseEntity<DtoOutputColeccion> crearColeccion(@RequestBody DtoInputColeccion coleccion) {
        DtoOutputColeccion resultado = coleccionService.crearColeccion(coleccion);
        return ResponseEntity.ok(resultado);
    }
}