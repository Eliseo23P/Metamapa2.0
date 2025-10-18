package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DtoOutputColeccion {
    private Long id;
    private String titulo;
    private String descripcion;
    private List<DtoInputHechoClientes> hechos;
   // private List<String> criteriosDePertenencia;
    //private List<String> fuentesAConsumir;
// private String handle; esto se hace mediante persistencia


    public DtoOutputColeccion() {}
    public DtoOutputColeccion(String titulo, String descripcion, List<DtoInputHechoClientes> hechos) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.hechos = hechos;
    }
}
