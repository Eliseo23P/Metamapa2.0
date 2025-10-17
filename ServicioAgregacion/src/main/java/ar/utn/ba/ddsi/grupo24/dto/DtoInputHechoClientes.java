package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DtoInputHechoClientes {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fecha_hecho;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<String> multimedias;


    public DtoInputHechoClientes() {}
    public DtoInputHechoClientes(Long id,
                                 String titulo,
                                 String descripcion,
                                 String categoria,
                                 Double latitud,
                                 Double longitud,
                                 List<String> multimedias,
                                 LocalDateTime fecha_hecho,
                                 LocalDateTime created_at,
                                 LocalDateTime updated_at) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.latitud = latitud;
        this.longitud = longitud;
        this.multimedias = multimedias;
        this.fecha_hecho = fecha_hecho;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
