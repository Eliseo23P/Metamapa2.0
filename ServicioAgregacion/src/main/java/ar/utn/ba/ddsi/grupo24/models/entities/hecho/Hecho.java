package ar.utn.ba.ddsi.grupo24.models.entities.hecho;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class Hecho {
    private Long idLocalAgregacion;
    private Long idExterno;
    private String titulo;
    private String descripcion;
    private String categoria;
    private List<String> multimedia;
    private LocalDate fechaHecho;
    private Long id_UsuarioOrigen;//puede ser nulleable en caso de no ser de dinamica
    private LocalDate fechaCreacion;
    private Boolean eliminado;//para que no agregacion no muestre nada
    private String fuente;
    private String dataset;
    private String apiNombre;

    public Boolean esMultimedia() {
        return multimedia != null && !multimedia.isEmpty();
    }
}
