package ar.utn.ba.ddsi.grupo24.client;

import ar.utn.ba.ddsi.grupo24.dto.LoginResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;


@Component
public class ClienteCatedraProxy {

    private final WebClient webClient;
    private String token;
    //el token cambia en cierto periodo de tiempo?
    public ClienteCatedraProxy(WebClient webClient) {
        this.webClient = webClient;
        login();
    }

    // GET /desastres?page=N&per_page=M

    public String getHecho(int page, int perPage) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/desastres")
                        .queryParam("page", page)
                        .queryParam("per_page", perPage)
                        .build())
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
    public String getHechoXid(int id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/desastres/{id}")
                        .build(id))
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }



    private void login() {
        Map<String, String> loginData = Map.of(
                "email", "ddsi@gmail.com",
                "password", "ddsi2025*"
        );

        LoginResponse response = webClient.post()
                .uri("/login")
                .bodyValue(loginData)
                .retrieve()
                .bodyToMono(LoginResponse.class)
                .block();

        token = response.data.access_token;

    }



}



