package ar.utn.ba.ddsi.grupo24.controller;

import ar.utn.ba.ddsi.grupo24.dto.DtoOutputHecho;
import ar.utn.ba.ddsi.grupo24.services.imple.FuenteProxyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FuenteProxyController {

    private final FuenteProxyService fuenteProxyService;

    public FuenteProxyController(FuenteProxyService fuenteProxyService) {
        this.fuenteProxyService = fuenteProxyService;
    }
    //http://localhost:8080/desastres?page=N&per_page=M
    @GetMapping("/desastres")
    public String traerHechos(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "3") int per_page) {
        return fuenteProxyService.obtenerHechos(page,per_page);
    }
    //http://localhost:8080/desastres/N
    @GetMapping("/desastres/{id}")
    public String traerHechoXid(@PathVariable int id) {
        return fuenteProxyService.obtenerHechoXid(id);
    }

    //listaAConsumir
    //armar un db para relacionar el hecho consumido para enviar

}
