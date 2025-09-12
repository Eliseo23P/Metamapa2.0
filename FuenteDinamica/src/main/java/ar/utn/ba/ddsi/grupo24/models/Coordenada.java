package ar.utn.ba.ddsi.grupo24.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordenada {
    private Double latitud;
    private Double longitud;
    public Coordenada(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
