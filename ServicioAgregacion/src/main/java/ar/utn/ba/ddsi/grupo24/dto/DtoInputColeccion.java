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
    //private List<String> fuentesAsociadas;
    private List<DtoCriteriosPertenencia> criteriosPertenencia;
}
//las fuentes asociadas tienen que ser una tabla?
//por el momento solo seran String
//los criteriosDePertencia siempre se enviaran en formato de lista