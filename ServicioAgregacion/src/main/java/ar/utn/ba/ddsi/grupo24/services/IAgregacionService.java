package ar.utn.ba.ddsi.grupo24.services;

import org.springframework.stereotype.Service;

@Service
public interface IAgregacionService {
    public String consumirHechos(int page,int perPage);
    public String hechoXid(int idHechoExterno);
    public void eliminarHecho(int idHechoExterno);
}
