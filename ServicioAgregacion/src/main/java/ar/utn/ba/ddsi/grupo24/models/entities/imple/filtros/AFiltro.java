package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.dto.DtoValorFiltro;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "filtros")
@DiscriminatorColumn(name = "tipo")
public abstract class AFiltro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public abstract Boolean cumpleFiltro(Hecho h, DtoValorFiltro valor);
}
