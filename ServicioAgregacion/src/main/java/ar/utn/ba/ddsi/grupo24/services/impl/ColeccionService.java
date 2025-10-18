package ar.utn.ba.ddsi.grupo24.services.impl;

import ar.utn.ba.ddsi.grupo24.FuentesCliente.FuenteProxyCliente;
import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.dto.DtoInputHechoClientes;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutputColeccion;
import ar.utn.ba.ddsi.grupo24.models.entities.coleccion.Coleccion;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros.*;
import ar.utn.ba.ddsi.grupo24.services.IColeccionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ColeccionService implements IColeccionService {

    private final FuenteProxyCliente fuenteProxy;

    public ColeccionService(FuenteProxyCliente fuenteProxy){
        this.fuenteProxy = fuenteProxy;
    }
    @Override
    public DtoOutputColeccion crearColeccion(DtoInputColeccion dtocoleccion) {
        Coleccion coleccion = this.mappingInput(dtocoleccion);
        //llamar a fuente dinamica y estatica dependiendo si estas estan asociadas.
       //unir con los hechos de proxy...
       //por ahora solo pediremos los hechos de proxy para verificar que anda esto
        List<DtoInputHechoClientes> hechos = this.fuenteProxy.getHecho();//listo

        List<Hecho> hechosProxy = this.mappingHecho(hechos);

        coleccion.aplicarCriteriosDePertenencia(hechosProxy);
        DtoOutputColeccion cwe = this.mappingOutput(coleccion);
        return cwe; //FINISH
    }
    //Con esto ya se crea una coleccion sin aplicar los criterios
    public Coleccion mappingInput(DtoInputColeccion dto){

        List<ACriterio> criterios = dto.getCriteriosPertenencia().stream().map(c -> {
            switch(c.getCriterioDePertenencia()) {
                case "titulo":
                    CriterioXTitulo filtroTitulo = new CriterioXTitulo();
                    filtroTitulo.setTitulo(c.getTitulo());
                    return filtroTitulo;
                    case "categoria":
                    CriterioXCategoria filtroCategoria = new CriterioXCategoria();
                    filtroCategoria.setCategoria(c.getCategoria());
                    return filtroCategoria;
                case "fechaHecho":
                    CriterioXFechaHecho filtroFecha = new CriterioXFechaHecho();
                    filtroFecha.setFechaSuceso(c.getFechaSuceso());
                    return filtroFecha;
                //case "multimedia":
                  //  CriterioXMultimedia filtroMultimedia = new CriterioXMultimedia();
                    //filtroMultimedia.setMultimedia(c.getMultimedia());
                    //return filtroMultimedia;
                default:
                    return null;
            }
        }).collect(Collectors.toList());
        Coleccion coleccion = new Coleccion(dto.getTitulo(),dto.getDescripcion(),criterios);
        return coleccion;
    }

    public DtoOutputColeccion mappingOutput(Coleccion coleccion) {
        // mapeo de los hechos
        List<DtoInputHechoClientes> hechosDto = coleccion.getHechos() != null
                ? coleccion.getHechos().stream()
                .map(h -> new DtoInputHechoClientes(
                        h.getId(),
                        h.getTitulo(),
                        h.getDescripcion(),
                        h.getCategoria(),
                        h.getLatitud(),
                        h.getLongitud(),
                        h.getMultimedia(),
                        h.getFechaHecho(),
                        h.getFechaCreacion(),
                        h.getFechaModificacion()
                ))
                .collect(Collectors.toList())
                : new ArrayList<>();

        return new DtoOutputColeccion(
                coleccion.getTitulo(),
                coleccion.getDescripcion(),
                hechosDto
        );
    }
    public List<Hecho> mappingHecho( List<DtoInputHechoClientes> dtohechos) {

        return dtohechos.stream()
                .map(dto -> {
                    Hecho hecho = new Hecho(
                            dto.getTitulo(),
                            dto.getDescripcion(),
                            dto.getCategoria(),
                            dto.getLatitud(),
                            dto.getLongitud(),
                            null, //fuente proxy
                            dto.getFecha_hecho(),
                            dto.getUpdated_at(),
                            null//el origen cual puede ser ?
                    );
                    hecho.setEliminado(false); // por defecto no eliminado
                    return hecho;
                })
                .collect(Collectors.toList());
    } //listo


}