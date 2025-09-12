package ar.utn.ba.ddsi.grupo24.services.imple;

import ar.utn.ba.ddsi.grupo24.dto.DtoCoordenada;
import ar.utn.ba.ddsi.grupo24.dto.DtoInputHecho;
import ar.utn.ba.ddsi.grupo24.dto.DtoMultimedia;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;
import ar.utn.ba.ddsi.grupo24.models.Coordenada;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import ar.utn.ba.ddsi.grupo24.models.Multimedia;
import ar.utn.ba.ddsi.grupo24.services.IFuenteDinamicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuenteDinamicaService implements IFuenteDinamicaService {

    @Autowired
    private IHechoRepositoryJPA HechoFuenteDinamicaRepository;

    @Override
    public void crearHecho(DtoInputHecho dtoHecho) {
        Hecho hecho = this.instanciarHecho(dtoHecho);
        this.HechoFuenteDinamicaRepository.save(hecho);
    }
    public Hecho instanciarHecho(DtoInputHecho dto){

        Coordenada coordenada = new Coordenada(dto.getCoordenada().getLatitud(),
                dto.getCoordenada().getLongitud());

        List<Multimedia> listaMultimedia = new ArrayList<>();
        if (dto.getMultimedias() != null) {
            for (DtoMultimedia m : dto.getMultimedias()) {
                listaMultimedia.add(new Multimedia(m.getTitulo(),m.getPath(),m.getDuracion()));
            }
        }
        return new Hecho(
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getCategoria(),
                listaMultimedia,
                coordenada,
                dto.getFechaHecho(),
                dto.getId_UsuarioOrigen()
        );
    }
    @Override
    public DtoOutPutHecho editarHecho(DtoInputHecho dto, Long id){

        if (dto.getId_UsuarioOrigen() == null) {
            throw new IllegalArgumentException("Solo un usuario registrado puede modificar un hecho.");
        }
        Hecho hechoAmodificar = this.HechoFuenteDinamicaRepository.findById(id).orElse(null);

        if (hechoAmodificar == null){
            throw  new IllegalArgumentException("No se encontro el hecho a modificar");
        }

        LocalDate fechaLimite = hechoAmodificar.getFechaCreacion().plusDays(7);
        LocalDate ahora = LocalDate.now();

        if (fechaLimite.isBefore(ahora)) {
            throw new IllegalArgumentException("No puede modificar el hecho debido a que superó el plazo de espera.");
        }
        hechoAmodificar.setTitulo(dto.getTitulo());
        hechoAmodificar.setDescripcion(dto.getDescripcion());
        hechoAmodificar.setCategoria(dto.getCategoria());
        //hechoAmodificar.setLatitud(dto.getLatitud());
        //hechoAmodificar.setLongitud(dto.getLongitud());
        // hechoAmodificar.setMultimedias(dto.getPathMultimedia());
        hechoAmodificar.setFechaHecho(dto.getFechaHecho());

        this.HechoFuenteDinamicaRepository.save(hechoAmodificar);

        return this.mapearDtoSalida(hechoAmodificar);

    }
    @Override
    public List<DtoOutPutHecho> findAll(){
        List<Hecho> hechos = this.HechoFuenteDinamicaRepository.findAll();
        return hechos.stream()
                .map(h -> this.mapearDtoSalida(h))
                .collect(Collectors.toList());
    }
    private DtoOutPutHecho mapearDtoSalida(Hecho h) {
        DtoCoordenada coordenada = new DtoCoordenada(h.getCoordenada().getLatitud(),
                h.getCoordenada().getLongitud());

        List<DtoMultimedia> listaMultimedia = new ArrayList<>();

        return new DtoOutPutHecho(
                h.getTitulo(),
                h.getDescripcion(),
                h.getCategoria(),
                listaMultimedia,
                coordenada,
                h.getFechaHecho(),
                h.getId_UsuarioOrigen(),
                h.getFechaCreacion()
        );
    }
    @Override
    public void eliminarHechoPorId(Long id) {
        Hecho hecho = HechoFuenteDinamicaRepository.findById(id).orElse(null);
        if (hecho == null) {
            throw new IllegalArgumentException("No se encontró el hecho con ID: " + id);
        }
        hecho.setEliminado(true);
        HechoFuenteDinamicaRepository.save(hecho);
    }

}


