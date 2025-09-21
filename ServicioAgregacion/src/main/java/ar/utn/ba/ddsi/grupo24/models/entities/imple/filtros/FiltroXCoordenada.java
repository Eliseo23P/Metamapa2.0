package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.Coordenada;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FiltroXCoordenada {
    @Id
    @GeneratedValue
    private Long id;
    private String campoAFiltrar;

    public FiltroXCoordenada(String campoAFiltrar) {this.campoAFiltrar = campoAFiltrar;}
    public FiltroXCoordenada() {}

    public Boolean pasaHecho(Hecho h , Coordenada coordenada){
        return h.getCoordenada().equals(coordenada);
    }
}