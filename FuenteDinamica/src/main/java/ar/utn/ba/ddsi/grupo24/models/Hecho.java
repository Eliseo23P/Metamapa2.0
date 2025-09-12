package ar.utn.ba.ddsi.grupo24.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Hecho {
    private String titulo;
    private String descripcion;
    private String categoria; // por ahora String , no me queda claro si usar clases.
    private List<Multimedia> multimedia;
    private Coordenada coordenada;
    private LocalDate fechaHecho;
    private Long id_UsuarioOrigen;
    private LocalDate fechaCreacion;
    private Boolean eliminado;

    public Hecho(String titulo, String descripcion, String categoria,
                 List<Multimedia> multimedias, Coordenada coordenada,
                 LocalDate fechaHecho, Long idUsuarioOrigen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.multimedia = multimedias != null ? multimedias : new ArrayList<>();//???
        this.coordenada = coordenada;
        this.fechaHecho = fechaHecho;
        this.id_UsuarioOrigen = idUsuarioOrigen;
        this.fechaCreacion = LocalDate.now();
    }


}
