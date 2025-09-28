package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("MULTIMEDIA")
public class FiltroXMultimedia extends AFiltro {

    private Boolean multimedia;
    @Override
    public Boolean cumpleFiltro(Hecho h, DtoValorFiltro valor) {
        Boolean esMultimedia = h.esMultimedia();
        return Objects.equals(esMultimedia, valor.getMultimedia());
    }
}