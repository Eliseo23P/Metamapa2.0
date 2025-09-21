package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.IFiltro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FiltroXTitulo implements IFiltro {
    @Id
    @GeneratedValue
    private Long id;
    private String campoAFiltrar;
    public FiltroXTitulo(String campoAFiltrar) {this.campoAFiltrar = campoAFiltrar;}
    public FiltroXTitulo() {}
    public Boolean cumpleFiltro(Hecho h , String titulo){
        return h.getTitulo() == titulo;
    }
}