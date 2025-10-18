package ar.utn.ba.ddsi.grupo24.services;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputHechoClientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAgregacionService {
    public List<DtoInputHechoClientes> consumirHechos();
    //public String hechoXid(int idHechoExterno);
    //    public void eliminarHecho(int idHechoExterno);
}
