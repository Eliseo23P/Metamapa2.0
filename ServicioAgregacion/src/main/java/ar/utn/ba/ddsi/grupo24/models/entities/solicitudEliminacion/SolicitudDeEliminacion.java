package ar.utn.ba.ddsi.grupo24.models.entities.solicitudEliminacion;

import ar.utn.ba.ddsi.grupo24.models.Hecho;

import java.time.LocalDateTime;


public class SolicitudDeEliminacion {
    public Long idSolicitudEliminacion;
    public Hecho hechoAEliminar;
    public String mensajeJustificativo;
    public String estado;
    public LocalDateTime fechaCreacion;
}
