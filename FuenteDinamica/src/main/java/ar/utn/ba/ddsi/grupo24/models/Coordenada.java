package ar.utn.ba.ddsi.grupo24.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Coordenada {
    private Double latitud;
    private Double longitud;
    public Coordenada() {}
    public Coordenada(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
