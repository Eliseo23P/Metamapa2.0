package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.IFiltro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FiltroXDescripcion implements IFiltro{
    @Id
    @GeneratedValue
    private Long id;
    private String campoAFiltrar;

    public FiltroXDescripcion(String campoAFiltrar) {this.campoAFiltrar = campoAFiltrar;}
    public FiltroXDescripcion() {}

    public Boolean pasaHecho(Hecho h , String descripcion){
        return h.getDescripcion() == descripcion;
    }
}

