package br.com.fiap.ms.pedidoreceiver.gateway.client;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Cliente para enviar pedidos para o serviço de pedidos.
 * Utiliza WebClient para comunicação assíncrona.
 * Este cliente envia pedidos para o serviço de pedidos
 * e não espera resposta, apenas registra o sucesso ou erro no envio.
 */
@Component
public class PedidoClient {

    private final WebClient webClient;

    public PedidoClient(WebClient.Builder builder,
                        @Value("${spring.webclient.pedido.url}") String pedidoServiceUrl) {
        this.webClient = builder.baseUrl(pedidoServiceUrl).build();
    }

    public void enviarPedido(Pedido pedido) {
        webClient.post()
                .uri("/pedidos")
                .bodyValue(pedido)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(resp -> System.out.println(" Pedido enviado com sucesso"))
                .doOnError(err -> System.err.println(" Erro ao enviar pedido: " + err.getMessage()))
                .subscribe(); // Assíncrono
    }
}
