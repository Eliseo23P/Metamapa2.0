package ar.utn.ba.ddsi.grupo24.models.entities;

import ar.utn.ba.ddsi.grupo24.models.Coordenada;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "hecho")
public class Hecho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    //@ElementCollection le indica a Hibernate que esta no es otra entidad, sino una lista de valores simples.
    //Hibernate creará una tabla intermedia, por ejemplo usuario_intereses, que guarda los intereses asociados al usuario.
    @ElementCollection
    private List<String> rutas;
    @Embedded
    private Coordenada coordenada;
    private LocalDate fechaHecho;
    private LocalDate fechaCreacion;
    private LocalDate fechaUltimaEdicion;
    private Long idUsuarioOrigen;//NULLEABLE

    public Hecho(String titulo,String descripcion,String categoria,List<String> rutas,Coordenada coordenada,
                 LocalDate fechaHecho,Long idUsuarioOrigen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.rutas = rutas;
        this.coordenada = coordenada;
        this.fechaHecho = fechaHecho;
        this.fechaCreacion = LocalDate.now();
        this.fechaUltimaEdicion = LocalDate.now();
        this.idUsuarioOrigen = idUsuarioOrigen;
    }

    public Hecho() {

    }
}
