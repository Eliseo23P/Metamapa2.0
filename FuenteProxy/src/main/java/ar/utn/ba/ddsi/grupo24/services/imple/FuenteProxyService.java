package ar.utn.ba.ddsi.grupo24.services.imple;

import ar.utn.ba.ddsi.grupo24.client.ClienteCatedraProxy;
import org.springframework.stereotype.Service;

@Service
public class FuenteProxyService {

    private final ClienteCatedraProxy clienteCatedraProxy;

    public FuenteProxyService(ClienteCatedraProxy clienteCatedraProxy) {
        this.clienteCatedraProxy = clienteCatedraProxy;
    }

    public String obtenerHechos(int page, int perPage) {
        return clienteCatedraProxy.getHecho(page,perPage);
    }

    public String obtenerHechoXid(int id){
        return  clienteCatedraProxy.getHechoXid(id);
    }


    //pregunta conceptual -> me llega en formato json de la catedra
    //esta informacion tendria que tranforla en un dtoInputHecho ?
    //osea para que me retorne un dto o directamente soy de paso mano

}