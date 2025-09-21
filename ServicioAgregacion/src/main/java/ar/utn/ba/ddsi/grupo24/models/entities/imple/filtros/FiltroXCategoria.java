package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.IFiltro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class FiltroXCategoria implements IFiltro {
    @Id
    @GeneratedValue
    private Long id;
    private String campoAFiltrar;

    public FiltroXCategoria(String campoAFiltrar) {this.campoAFiltrar = campoAFiltrar;}
    public FiltroXCategoria() {}

    public Boolean cumpleFiltro(Hecho h , String categoria){
        return h.getCategoria() == categoria;
    }

}