package ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros;

import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "filtros")
@DiscriminatorColumn(name = "tipo")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "criteriosDePertenencia"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CriterioXTitulo.class, name = "titulo"),
        @JsonSubTypes.Type(value = CriterioXCategoria.class, name = "categoria"),
        @JsonSubTypes.Type(value = CriterioXFechaHecho.class, name = "fechaSuceso"),
        @JsonSubTypes.Type(value = CriterioXMultimedia.class, name = "multimedia")
})
public abstract class ACriterio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public abstract Boolean cumpleFiltro(Hecho h);
}
