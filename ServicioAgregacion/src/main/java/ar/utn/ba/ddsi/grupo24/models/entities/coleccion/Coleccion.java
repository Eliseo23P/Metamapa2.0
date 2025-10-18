package ar.utn.ba.ddsi.grupo24.models.entities.coleccion;

import ar.utn.ba.ddsi.grupo24.models.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros.ACriterio;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Coleccion {
   // private Long id;
   // private String handle;
    private String titulo;
    private String descripcion;
    private List<Hecho> hechos;
    private List<ACriterio> criteriosDePertenencia;

    public Coleccion(String titulo,String descripcion,List<ACriterio> criteriosDePertenencia) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.criteriosDePertenencia = criteriosDePertenencia;
    }
    //private List<String>  fuentesAConsumir;





    //buen problema...
    //a coleccion le pertence la responsibilidad de filrar sus hechos?
    //tiene conexion con service...
    // hago solo any para testear y no romperme la cabeza para ver si cumple todos los critrios los hechos obtenidos
    public void aplicarCriteriosDePertenencia(List<Hecho> hechos) {
        this.hechos = hechos.stream()
                .filter(h -> criteriosDePertenencia.stream()
                        .anyMatch(filtro -> filtro.cumpleFiltro(h)))
                .collect(Collectors.toList());
    }


}
