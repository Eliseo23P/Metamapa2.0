package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("FECHASUCESO")
public class FiltroXFechaHecho extends AFiltro{

    private LocalDate fechaSuceso;
    @Override
    public Boolean cumpleFiltro(Hecho h, DtoValorFiltro valor) {
        return Objects.equals(h.getFechaHecho(), valor.getFechaSuceso());
    }
}
