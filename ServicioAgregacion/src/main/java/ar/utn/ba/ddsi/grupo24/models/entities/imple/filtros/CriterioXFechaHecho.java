package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("FECHASUCESO")
public class CriterioXFechaHecho extends ACriterio {

    private LocalDate fechaSuceso;
    @Override
    public Boolean cumpleFiltro(Hecho h) {
        return Objects.equals(h.getFechaHecho(), this.fechaSuceso);
    }
}
