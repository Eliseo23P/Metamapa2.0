package ar.utn.ba.ddsi.grupo24.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DtoOutPutHecho {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private List<String> multimedias;
    private Double longitud;
    private Double latitud;
    private LocalDate fechaHecho;
    private Long id_UsuarioOrigen;
    private LocalDate fechaCreacion;
    private LocalDate fechaUltimaModificacion;

    public DtoOutPutHecho(Long id,String titulo, String descripcion, String categoria,
                          List<String> multimedias, Double latitud,Double longitud,
                          LocalDate fechaHecho, Long id_UsuarioOrigen,LocalDate fechaCreacion,
                          LocalDate fechaUltimaModificacion
) {
        this.id = id;
        this.fechaUltimaModificacion=fechaUltimaModificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.multimedias = multimedias;
        this.longitud = longitud;
        this.latitud = latitud;
        this.fechaHecho = fechaHecho;
        this.id_UsuarioOrigen = id_UsuarioOrigen;
        this.fechaCreacion = fechaCreacion;
    }
}
