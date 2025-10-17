package ar.utn.ba.ddsi.grupo24.FuentesCliente;

import ar.utn.ba.ddsi.grupo24.dto.DtoInputHechoClientes;
import ar.utn.ba.ddsi.grupo24.dto.HechoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class FuenteProxyCliente {

    private final WebClient webClient;
    public FuenteProxyCliente(WebClient webClient) {
        this.webClient = webClient;
    }

    //mientras tanto solo queremos probar de fuente proxy
    public List<DtoInputHechoClientes> getHecho() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("page", 1)
                        .queryParam("per_page", 20)
                        .build())
                .retrieve()
                .bodyToFlux(DtoInputHechoClientes.class) // convierte cada elemento del array a DtoInputHechoClientes
                .collectList()                           // junta todos en una lista
                .block();                                 // espera el resultado
    }


    public DtoInputHechoClientes getHechoXid(Long id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("{id}")
                        .build(id))
                .retrieve()
                .bodyToMono(DtoInputHechoClientes.class) // 👈 Mono para un solo objeto
                .block();
    }


    // public String eliminarHecho(int id, String nombreApi) {
    //        return webClient.delete()
    //                .uri(uriBuilder -> uriBuilder
    //                        .path("/{nombreApi}/{id}")
    //                        .build(nombreApi,id))
    //                .retrieve()
    //                .bodyToMono(String.class)
    //                .block();
    //    }
}
