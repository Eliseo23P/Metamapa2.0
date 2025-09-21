package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.Hecho;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FiltroXMultimedia {
    @Id
    @GeneratedValue
    private Long id;
    private String campoAFiltrar;

    public FiltroXMultimedia(String campoAFiltrar) {this.campoAFiltrar = campoAFiltrar;}
    public FiltroXMultimedia() {}

    public Boolean pasaHecho(Hecho h ){
        return h.esMultimedia();
    }
}