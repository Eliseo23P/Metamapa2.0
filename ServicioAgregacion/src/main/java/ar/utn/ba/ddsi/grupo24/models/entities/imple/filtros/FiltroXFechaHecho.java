package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.Hecho;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
public class FiltroXFechaHecho {
    @Id
    @GeneratedValue
    private Long id;
    private String campoAFiltrar;

    public FiltroXFechaHecho(String campoAFiltrar) {this.campoAFiltrar = campoAFiltrar;}
    public FiltroXFechaHecho() {}

    public Boolean pasaHecho(Hecho h , LocalDate fecha){
        return h.getFechaHecho().equals(fecha);
    }
}
