package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class DtoOutputHecho {
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fecha_hecho;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;//ultima vez que se edito
}

//{
//    "id": 32,
//    "titulo": "Confirman Fenómeno de frío intenso de gran magnitud en Río Tercero, Córdoba",
//    "descripcion": "Una fenómeno de frío intenso de gran magnitud afectó a Río Tercero, Córdoba. El incidente dejando a varios sectores sin comunicación. Defensa Civil coordina las tareas de asistencia y reconstrucción.",
//    "categoria": "Fenómeno de frío intenso",
//    "latitud": -32.192286,
//    "longitud": -64.076993,
//    "fecha_hecho": "2007-11-07T00:00:00",
//    "created_at": "2025-05-06T22:14:14",
//    "updated_at": "2025-05-06T22:14:14"
//}
//me llega esa informacion - funcioan