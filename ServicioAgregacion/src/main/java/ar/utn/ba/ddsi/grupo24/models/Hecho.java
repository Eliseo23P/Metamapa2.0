package ar.utn.ba.ddsi.grupo24.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

@Entity
public class Hecho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;

    @ElementCollection
    @CollectionTable(name = "hecho_multimedia", joinColumns = @JoinColumn(name = "hecho_id"))
    @Column(name = "archivo_url")
    private List<String> multimedia;
    //@Embedded
   // private Coordenada coordenada;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHecho;
    private Long id_UsuarioOrigen;
    private LocalDateTime fechaCreacion;
    private Boolean eliminado;
    private LocalDateTime fechaModificacion;
    public Hecho() {}
    public Hecho(String titulo,
                 String descripcion,
                 String categoria,
                 Double latitud,
                 Double longitud,
                 List<String> multimedias,
                 LocalDateTime fechaHecho,
                 LocalDateTime fechaModificacion, //pensar en trazabilidad
                 Long idUsuarioOrigen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.multimedia = multimedias != null ? multimedias : new ArrayList<>();//???
        //this.coordenada = coordenada;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHecho = fechaHecho;
        this.id_UsuarioOrigen = idUsuarioOrigen;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = fechaModificacion;
    }

}
