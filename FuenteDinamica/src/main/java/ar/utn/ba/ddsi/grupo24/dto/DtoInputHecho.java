package ar.utn.ba.ddsi.grupo24.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public class DtoInputHecho {
    private String titulo;
    private String descripcion;
    private String categoria;
    private List<MultipartFile> multimedias;
    private Double longitud;
    private Double latitud;
    private LocalDate fechaHecho;
    private Long id_UsuarioOrigen;//nulleable
}
