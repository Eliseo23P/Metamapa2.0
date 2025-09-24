package ar.utn.ba.ddsi.grupo24.services.impl;

import ar.utn.ba.ddsi.grupo24.FuentesCliente.FuenteProxyCliente;
import ar.utn.ba.ddsi.grupo24.dto.DtoOutPutHecho;
import ar.utn.ba.ddsi.grupo24.models.Hecho;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgregacionService {

    private final FuenteProxyCliente fuenteProxy;

    public AgregacionService(FuenteProxyCliente fuenteProxy){
        this.fuenteProxy = fuenteProxy;
    }

    public String consumirHechos(int page,int perPage){
        return this.fuenteProxy.getHecho(page,perPage);
    }
    //String???

    //esto deberia de estar en otro lugar
    public String hechoXid(int idHechoLocal){

        Hecho hecho = this.repoHecho.findById(idHechoLocal);

        if(hecho.getFuente()== Proxy){
            int idHecho = hecho.getIdHecho();
            String nombreApi = hecho.getNombreApi();
            return this.fuenteProxy.getHechoXid(idHecho,nombreApi);
        }

        return this.fuenteDinamic.getHechoXid(idHecho);
    }

    public void eliminarHecho(int idHechoLocal){
        int idHecho=2;
        String nombreApi= "api_catedra";
        this.fuenteProxy.eliminarHecho(idHecho,nombreApi);
    }
}
// y si la fuente es una clase?
