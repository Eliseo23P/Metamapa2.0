package ar.utn.ba.ddsi.grupo24.models.entities.coleccion;

import ar.utn.ba.ddsi.grupo24.models.entities.enums.Fuente;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros.IFiltro;

import java.util.List;

public class Coleccion {
    private Long id;
    private String handle;
    private List<Hecho> hechos;
    private List<IFiltro> criteriosDePertenencia;
    private List<Fuente>  fuentesAConsumir;
}
