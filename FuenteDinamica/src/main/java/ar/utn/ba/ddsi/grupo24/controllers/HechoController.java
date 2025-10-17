package ar.utn.ba.ddsi.grupo24.controllers;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputHecho;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;
import ar.utn.ba.ddsi.grupo24.services.IFuenteDinamicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fuentes/dinamica/hechos")
public class HechoController {

    private final IFuenteDinamicaService hechoService;

    public HechoController(IFuenteDinamicaService hechoService) {
        this.hechoService = hechoService;
    }

    @GetMapping("/hechos")
    public ResponseEntity<List<DtoOutPutHecho>> traerHechos() {
        List<DtoOutPutHecho> hechoList = hechoService.findAll();
        return ResponseEntity.ok(hechoList);
    }

    @PostMapping("/")
    public ResponseEntity<?> subirHecho(@RequestPart("hecho") DtoInputHecho dtoHecho,
                                        @RequestPart("multimedia") List<MultipartFile> multimedia) {
        String carpetaDestino = "/home/eliseo/Escritorio/multimedia/";
        File carpeta = new File(carpetaDestino);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        try {
            List<String> rutasGuardadas = new ArrayList<>();
            for (MultipartFile mul : multimedia) {
                File archivoDestino = new File(carpetaDestino + mul.getOriginalFilename());
                mul.transferTo(archivoDestino);
                rutasGuardadas.add(archivoDestino.getAbsolutePath());
                System.out.println("Archivo guardado: " + archivoDestino.getAbsolutePath());
        }
            hechoService.crearHecho(dtoHecho,rutasGuardadas);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar el hecho");
        }
    }
    //------------------------------------------------------------------------------------
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
