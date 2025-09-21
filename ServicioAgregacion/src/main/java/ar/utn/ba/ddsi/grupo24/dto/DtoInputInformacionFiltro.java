package ar.utn.ba.ddsi.grupo24.dto;

import java.time.LocalDate;


public class DtoInputInformacionFiltro {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private Boolean multimedia;
    //se puede filtrar hechos que tienen multimedia
    //private Coordenada coordenada; no me cuadra...
    private LocalDate fechaHecho;
    private Long id_Origen;
    private LocalDate fechaCreacion;
}
// este dto estaria en el dominio? tipo lo uso como paramtro el filtro