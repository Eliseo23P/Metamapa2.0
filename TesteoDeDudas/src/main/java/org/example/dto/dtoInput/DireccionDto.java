package org.example.dto.dtoInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionDto {
    private String calle;
    private String numero;
    private String ciudad;
    private String pais;
    private String codigoPostal;
}