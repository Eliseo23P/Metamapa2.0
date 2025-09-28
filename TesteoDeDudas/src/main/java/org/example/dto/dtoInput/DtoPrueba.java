package org.example.dto.dtoInput;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPrueba{
    private String nombre;
    private String email;
    private String telefono;
    private DireccionDto direccion;
}

public class DireccionDto {
    private String calle;
    private String numero;
    private String ciudad;
    private String pais;
    private String codigoPostal;
}