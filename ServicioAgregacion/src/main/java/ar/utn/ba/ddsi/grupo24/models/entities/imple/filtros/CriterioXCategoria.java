package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;


import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
@Entity
@DiscriminatorValue("CATEGORIA")
public class CriterioXCategoria extends ACriterio {
    private String categoria;
    @Override
    public Boolean cumpleFiltro(Hecho h) {
        return Objects.equals(h.getCategoria(),this.categoria);
    }
}