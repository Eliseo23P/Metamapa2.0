package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("TITULO")
public class FiltroXTitulo extends AFiltro {
    @Column
    private String titulo;

    @Override
    public Boolean cumpleFiltro(Hecho h, DtoValorFiltro valor) {
        return Objects.equals(h.getTitulo(), valor.getTitulo());
    }
}