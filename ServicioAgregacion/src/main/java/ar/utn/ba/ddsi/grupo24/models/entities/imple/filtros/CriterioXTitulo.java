package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("TITULO")
public class CriterioXTitulo extends ACriterio {
    @Column
    private String titulo;

    @Override
    public Boolean cumpleFiltro(Hecho h) {
        return Objects.equals(h.getTitulo(),this.titulo);
    }
}