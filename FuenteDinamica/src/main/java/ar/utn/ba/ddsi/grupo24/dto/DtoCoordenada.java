package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCoordenada {
    private double latitud;
    private double longitud;
    public DtoCoordenada(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
