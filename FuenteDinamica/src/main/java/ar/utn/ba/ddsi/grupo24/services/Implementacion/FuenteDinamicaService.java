package ar.utn.ba.ddsi.grupo24.services.Implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuenteDinamicaService implements IFuenteDinamicaService {

    @Autowired
    private IHechoRepositoryJPA HechoFuenteDinamicaRepository;

    @Override
    public DtoOutPutHecho crearHecho(DtoInputHecho dtoHecho) {
        Hecho hecho = this.instanciarHecho(dtoHecho);
       // aca tiene que existir una exep this.HechoFuenteDinamicaRepository.save(hechoASubir);
        return mapearDtoOutput(hechoASubir);
    }
    public Hecho instanciarHecho(DtoInputHecho dto){

        //instanciar primero coordenadas-> si es un data object , para que?
        //multimedia si es que hay- este si
        return new Hecho(
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getCategoria(),
                dto.getFechaDeCuandoSucedioElEvento(),
                dto.getId_UsuarioOrigen(),
                LocalDateTime.now()
        );
    }
    public DtoOutPutHecho mapearDtoOutput(Hecho h) {

        DtoOutPutHecho dto = new DtoOutPutHecho();
        dto.setId(h.getId());
        dto.setTitulo(h.getTitulo());
        dto.setDescripcion(h.getDescripcion());
        dto.setCategoria(h.getCategoria());
        //por el momento el path no lo cargo
        dto.setLatitud(h.getLatitud());
        dto.setLongitud(h.getLongitud());
        dto.setFechaDeCuandoSucedioElEvento(h.getFechaAcontecimiento());
        dto.setId_Usuario(h.getId());
        return dto;
    }
    @Override
    public DtoOutPutHecho editarHecho(DtoInputHecho dto, Long id){

        if (dto.getId_Usuario() == null) {
            throw new IllegalArgumentException("Solo un usuario registrado puede modificar un hecho.");
        }
        Hecho hechoAmodificar = this.HechoFuenteDinamicaRepository.findById(id).orElse(null);

        if (hechoAmodificar == null){
            throw  new IllegalArgumentException("No se encontro el hecho a modificar");
        }

        LocalDate fechaLimite = hechoAmodificar.getFechaCarga().plusDays(7);
        LocalDate ahora = LocalDate.now();

        if (fechaLimite.isBefore(ahora)) {
            throw new IllegalArgumentException("No puede modificar el hecho debido a que superó el plazo de espera.");
        }
        hechoAmodificar.setTitulo(dto.getTitulo());
        hechoAmodificar.setDescripcion(dto.getDescripcion());
        hechoAmodificar.setCategoria(dto.getCategoria());
        hechoAmodificar.setLatitud(dto.getLatitud());
        hechoAmodificar.setLongitud(dto.getLongitud());
        // hechoAmodificar.setMultimedias(dto.getPathMultimedia());
        hechoAmodificar.setFechaAcontecimiento(dto.getFechaDeCuandoSucedioElEvento());

        this.HechoFuenteDinamicaRepository.save(hechoAmodificar);

        return this.mapearDtoSalida(hechoAmodificar);

    }
    @Override
    public List<DtoOutPutHecho> findAll(){
        List<Hecho> hechos = this.HechoFuenteDinamicaRepository.findAll();
        return hechos.stream()
                .map(h -> this.mapearDtoSalida(h)).collect(Collectors.toUnmodifiableList());
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


