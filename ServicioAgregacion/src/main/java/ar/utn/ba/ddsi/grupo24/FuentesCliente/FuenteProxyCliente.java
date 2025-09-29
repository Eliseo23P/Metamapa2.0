package ar.utn.ba.ddsi.grupo24.FuentesCliente;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component
public class FuenteProxyCliente {

    private final WebClient webClient;

    public FuenteProxyCliente(WebClient webClient) {
        this.webClient = webClient;
    }
//tengo que cambiar esto a un dto la RE PTM
    public String getHecho(int page, int perPage) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("page", page)
                        .queryParam("per_page", perPage)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getHechoXid(int id, String nombreApi) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/{nombreApi}/{id}")
                        .build(nombreApi,id))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String eliminarHecho(int id, String nombreApi) {
        return webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path("/{nombreApi}/{id}")
                        .build(nombreApi,id))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
