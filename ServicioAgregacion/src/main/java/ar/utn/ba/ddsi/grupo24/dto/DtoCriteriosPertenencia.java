package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class DtoCriteriosPertenencia {
    private String criterioDePertenencia;
    private String titulo;
    private String categoria;
    private LocalDate fechaSuceso;
    private Boolean multimedia;

}
//aclaracion los datos matchean automaticamente y solo hace uso de las atributos de la
//clase especifica
//por ejemplo criterioDePertencia -> Titulo
//este solo tiene que tener el atributo titulo los demas quedan null.