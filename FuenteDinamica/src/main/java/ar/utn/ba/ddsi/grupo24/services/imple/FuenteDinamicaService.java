package ar.utn.ba.ddsi.grupo24.services.imple;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputHecho;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;
import ar.utn.ba.ddsi.grupo24.models.Coordenada;


import ar.utn.ba.ddsi.grupo24.models.entities.Hecho;
import ar.utn.ba.ddsi.grupo24.services.IFuenteDinamicaService;
import ar.utn.ba.ddsi.grupo24.services.IHechoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuenteDinamicaService implements IFuenteDinamicaService {

    @Autowired
    private IHechoRepositoryJPA HechoFuenteDinamicaRepository;

    @Override
    public void crearHecho(DtoInputHecho dtoHecho,List<String> rutas) throws IOException {
        //verificar si la lista esta vacia
        Hecho hecho = this.instanciarHecho(dtoHecho,rutas);
        this.HechoFuenteDinamicaRepository.save(hecho);
    }

    @Override
    public DtoOutPutHecho editarHecho(DtoInputHecho dto, Long id) {
        return null;
    }

    ////    //@Override
////    //public DtoOutPutHecho editarHecho(DtoInputHecho dto, Long id){
////
////        if (dto.getId_UsuarioOrigen() == null) {
////            throw new IllegalArgumentException("Solo un usuario registrado puede modificar un hecho.");
////        }
////        Hecho hechoAmodificar = this.HechoFuenteDinamicaRepository.findById(id).orElse(null);
////
////        if (hechoAmodificar == null){
////            throw  new IllegalArgumentException("No se encontro el hecho a modificar");
////        }
////
////        LocalDate fechaLimite = hechoAmodificar.getFechaCreacion().plusDays(7);
////        LocalDate ahora = LocalDate.now();
////
////        if (fechaLimite.isBefore(ahora)) {
////            throw new IllegalArgumentException("No puede modificar el hecho debido a que superó el plazo de espera.");
////        }
////
////        hechoAmodificar.setTitulo(dto.getTitulo());
////        hechoAmodificar.setDescripcion(dto.getDescripcion());
////        hechoAmodificar.setCategoria(dto.getCategoria());
////       // hechoAmodificar.setCoordenada()
////       // hechoAmodificar.setLongitud(dto.getLongitud());
////        //hechoAmodificar.setMultimedia(dto.getMultimedias());
////        hechoAmodificar.setFechaHecho(dto.getFechaHecho());
////
////        this.HechoFuenteDinamicaRepository.save(hechoAmodificar);
////
////        return this.mapearDtoSalida(hechoAmodificar);
////
////    }
    @Override
    public List<DtoOutPutHecho> findAll(){
        List<Hecho> hechos = this.HechoFuenteDinamicaRepository.findAll();
        return hechos.stream()
                .map(h -> this.mapearDtoSalida(h))
                .collect(Collectors.toList());
    }//fijar dto salida

    @Override
    public void eliminarHechoPorId(Long id) {

    }
//    @Override
//    public void eliminarHechoPorId(Long id) {
//        Hecho hecho = HechoFuenteDinamicaRepository.findById(id).orElse(null);
//        if (hecho == null) {
//            throw new IllegalArgumentException("No se encontró el hecho con ID: " + id);
//        }
//        hecho.setEliminado(true);
//        HechoFuenteDinamicaRepository.save(hecho);
//    }

    private DtoOutPutHecho mapearDtoSalida(Hecho h) {

        return new DtoOutPutHecho(
                h.getId(),
                h.getTitulo(),
                h.getDescripcion(),
                h.getCategoria(),
                h.getRutas(),
                h.getCoordenada().getLatitud(),
                h.getCoordenada().getLongitud(),
                h.getFechaHecho(),
                h.getIdUsuarioOrigen(),
                h.getFechaCreacion(),
                h.getFechaUltimaEdicion()
        );
    }
    public Hecho instanciarHecho(DtoInputHecho dto,List<String> rutas) throws IOException {

        Coordenada coordenada = new Coordenada(dto.getLatitud(),
                dto.getLongitud());

        return new Hecho(
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getCategoria(),
                rutas,
                coordenada,
                dto.getFechaHecho(),
                dto.getId_UsuarioOrigen()
        );
    }


}


