package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class DtoInputColeccion {
    private String titulo;
    private String descripcion;
    private List<Long> fuentesAsociadas;
    private List<String> criteriosPertenencia;
    private DtoValorFiltro valores;//algunos campos pueden ser null
}