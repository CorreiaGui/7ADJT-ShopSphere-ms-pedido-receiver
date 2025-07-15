package br.com.fiap.ms.pedidoreceiver.gateway.external;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import br.com.fiap.ms.pedidoreceiver.gateway.external.dto.EstoqueStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EstoqueRestClient implements EstoqueClient {

    private final RestTemplate restTemplate;

    public EstoqueRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Verifica a disponibilidade de estoque para o pedido.
     *
     * @param pedido O pedido a ser verificado.
     * @return true se o estoque estiver disponível, false caso contrário.
     */
    @Override
    public boolean verificarDisponibilidade(Pedido pedido) {
        //TODO url verificar se é a correta
        ResponseEntity<EstoqueStatus> response = restTemplate.postForEntity(
                "http://estoque-service/api/estoque/verificar", pedido, EstoqueStatus.class
        );
        return response.getBody() != null && response.getBody().isDisponivel();
    }
}
