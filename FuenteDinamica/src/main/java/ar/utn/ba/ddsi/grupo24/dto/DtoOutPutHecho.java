package ar.utn.ba.ddsi.grupo24.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DtoOutPutHecho {
    private String titulo;
    private String descripcion;
    private String categoria;
    private List<DtoMultimedia> multimedias;
    private DtoCoordenada coordenada;
    private LocalDate fechaHecho;
    private Long id_UsuarioOrigen;
    private LocalDate fechaCreacion;

    public DtoOutPutHecho(String titulo, String descripcion, String categoria,
                          List<DtoMultimedia> multimedias, DtoCoordenada coordenada,
                          LocalDate fechaHecho, Long id_UsuarioOrigen,LocalDate fechaCreacion
) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.multimedias = multimedias;
        this.coordenada = coordenada;
        this.fechaHecho = fechaHecho;
        this.id_UsuarioOrigen = id_UsuarioOrigen;
        this.fechaCreacion = fechaCreacion;
    }
}
