package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dtos.DtoInputHecho;
import ar.utn.ba.ddsi.grupo24.services.IFuenteDinamicaService;
import ar.utn.ba.ddsi.grupo24.services.ISeederService;
import ar.utn.ba.ddsi.grupo24.dtos.DtoOutPutHecho;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuentes/dinamicas/hechos")
public class HechoController {

    private final IFuenteDinamicaService hechoService;
    private final ISeederService seederService;

    public HechoController(IFuenteDinamicaService hechoService, ISeederService seederService) {
        this.hechoService = hechoService;
        this.seederService = seederService;
    }

    @GetMapping()
    public ResponseEntity<List<DtoOutPutHecho>> traerHechos() {
        List<DtoOutPutHecho> hechoList = hechoService.findAll();
        return ResponseEntity.ok(hechoList);
    }

    @PostMapping()
    public ResponseEntity<DtoOutPutHecho> subirHecho(@RequestBody DtoInputHecho dtoInputHecho) {
        DtoOutPutHecho newHecho = hechoService.crearHecho(dtoInputHecho);
        return ResponseEntity.ok(newHecho);
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
    public ResponseEntity<Void> eliminarHecho(@PathVariable Long id) {
        try {
            hechoService.eliminarHechoPorId(id);
            return ResponseEntity.ok("Hecho eliminado lógicamente (marcado como eliminado).");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/inicializar")
    public boolean inicializarDatos() {
        this.seederService.init();
        return true;
    }

}
