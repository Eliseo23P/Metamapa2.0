package ar.utn.ba.ddsi.grupo24.services;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutputColeccion;

public interface IColeccionService {

    public DtoOutputColeccion crearColeccion(DtoInputColeccion coleccion);
}
