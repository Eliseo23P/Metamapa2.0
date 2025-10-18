package ar.utn.ba.ddsi.grupo24.services.imple;

import ar.utn.ba.ddsi.grupo24.client.ClienteCatedraProxy;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutputHecho;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuenteProxyService {

    private final ClienteCatedraProxy clienteCatedraProxy;

    public FuenteProxyService(ClienteCatedraProxy clienteCatedraProxy) {
        this.clienteCatedraProxy = clienteCatedraProxy;
    }

    public List<DtoOutputHecho> obtenerHechos(int page, int perPage) {
        return clienteCatedraProxy.getHecho(page,perPage);
    }

    public DtoOutputHecho obtenerHechoXid(int id){
        return  clienteCatedraProxy.getHechoXid(id);
    }


    //pregunta conceptual -> me llega en formato json de la catedra
    //esta informacion tendria que tranforla en un dtoInputHecho ?
    //osea para que me retorne un dto o directamente soy de paso mano

}