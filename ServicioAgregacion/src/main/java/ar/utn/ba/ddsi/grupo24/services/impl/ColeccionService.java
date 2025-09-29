package ar.utn.ba.ddsi.grupo24.services.impl;

import ar.utn.ba.ddsi.grupo24.FuentesCliente.FuenteProxyCliente;
import ar.utn.ba.ddsi.grupo24.dto.DtoInputColeccion;
import ar.utn.ba.ddsi.grupo24.models.entities.coleccion.Coleccion;
import ar.utn.ba.ddsi.grupo24.models.entities.hecho.Hecho;
import ar.utn.ba.ddsi.grupo24.models.entities.imple.filtros.*;
import ar.utn.ba.ddsi.grupo24.services.IColeccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ColeccionService implements IColeccionService {

    private final FuenteProxyCliente fuenteProxy;

    public ColeccionService(FuenteProxyCliente fuenteProxy){
        this.fuenteProxy = fuenteProxy;
    }
//DtoOutputColeccion
    @Override
    public String crearColeccion(DtoInputColeccion dtocoleccion) {
        Coleccion coleccion = this.mappingInput(dtocoleccion);
        //llamar a fuente dinamica y estatica dependiendo si estas estan asociadas.
        //unir con los hechos de proxy...
        //por ahora solo pediremos los hechos de proxy para verificar que anda esto

        String hechos = this.fuenteProxy.getHecho(2,20);
        coleccion.aplicarCriteriosDePertenencia(hechos);
        return DtoInputColeccion;
    }
    public Coleccion mappingInput(DtoInputColeccion dto){
        Coleccion coleccion = new Coleccion();
        coleccion.setTitulo(dto.getTitulo());
        coleccion.setDescripcion(dto.getDescripcion());
        coleccion.setFuentesAConsumir(dto.getFuentesAsociadas());

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
                case "multimedia":
                    CriterioXMultimedia filtroMultimedia = new CriterioXMultimedia();
                    filtroMultimedia.setMultimedia(c.getMultimedia());
                    return filtroMultimedia;
                default:
                    return null;
            }
        }).collect(Collectors.toList());
        coleccion.setCriteriosDePertenencia(criterios);
        return coleccion;
    }

}
