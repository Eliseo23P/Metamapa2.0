package ar.utn.ba.ddsi.grupo24.services;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputHecho;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;

import java.io.IOException;
import java.util.List;

public interface IFuenteDinamicaService {
    void crearHecho(DtoInputHecho dtoHecho,List<String> rutas) throws IOException;

    DtoOutPutHecho editarHecho(DtoInputHecho dto, Long id);

    List<DtoOutPutHecho> findAll();

    void eliminarHechoPorId(Long id);
}
