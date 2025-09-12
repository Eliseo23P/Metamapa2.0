package ar.utn.ba.ddsi.grupo24.dto;

import ar.utn.ba.ddsi.grupo24.models.Multimedia;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DtoInputHecho {
    private String titulo;
    private String descripcion;
    private String categoria;
    private List<DtoMultimedia> multimedias;
    private DtoCoordenada coordenada;
    private LocalDate fechaHecho;
    private Long id_UsuarioOrigen;
}
