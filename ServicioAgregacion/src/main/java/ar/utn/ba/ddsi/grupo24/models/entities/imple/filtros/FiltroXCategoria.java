package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;


import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
@Entity
@DiscriminatorValue("CATEGORIA")
public class FiltroXCategoria extends AFiltro {
    private Long id;
    private String categoria;
    @Override
    public Boolean cumpleFiltro(Hecho h, DtoValorFiltro valor) {
        return Objects.equals(h.getCategoria(), valor.getCategoria());
    }
}