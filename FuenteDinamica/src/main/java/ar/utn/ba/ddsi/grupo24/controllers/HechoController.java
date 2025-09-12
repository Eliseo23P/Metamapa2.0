package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputHecho;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;
import ar.utn.ba.ddsi.grupo24.services.IFuenteDinamicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuentes/dinamicas/hechos")
public class HechoController {

    private final IFuenteDinamicaService hechoService;

    public HechoController(IFuenteDinamicaService hechoService) {
        this.hechoService = hechoService;
    }

    @GetMapping()
    public ResponseEntity<List<DtoOutPutHecho>> traerHechos() {
        List<DtoOutPutHecho> hechoList = hechoService.findAll();
        return ResponseEntity.ok(hechoList);
    }
    @PostMapping
    public ResponseEntity<?> subirHecho(@RequestBody DtoInputHecho dtoHecho) {
        try {
            hechoService.crearHecho(dtoHecho);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el hecho");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editarHecho(@RequestBody DtoInputHecho dtoInputHecho, @PathVariable Long id) {
        try {
            DtoOutPutHecho hecho = hechoService.editarHecho(dtoInputHecho, id);
            return ResponseEntity.ok(hecho);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarHecho(@PathVariable Long id) {
        try {
            hechoService.eliminarHechoPorId(id);
            return ResponseEntity.ok("Hecho eliminado lógicamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
