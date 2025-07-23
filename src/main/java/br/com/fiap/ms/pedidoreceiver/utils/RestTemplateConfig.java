package br.com.fiap.ms.pedidoreceiver.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuração do RestTemplate para realizar chamadas HTTP.
 * Utilizado para interagir com serviços externos, como o serviço de pagamento.
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
