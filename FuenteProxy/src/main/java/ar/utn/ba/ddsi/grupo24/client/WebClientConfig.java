package ar.utn.ba.ddsi.grupo24.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

@Bean
public WebClient webClient() {
    return WebClient.builder()
            .baseUrl("https://api-ddsi.disilab.ar/public/api")
            .build();
}
}
