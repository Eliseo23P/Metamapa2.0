package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DtoValorFiltro {
    private String categoria;
    private String titulo;
    private LocalDate fechaSuceso;
    private LocalDate fechaCreacion;
    private Boolean multimedia;
}
