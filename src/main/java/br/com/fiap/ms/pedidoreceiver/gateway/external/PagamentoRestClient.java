package br.com.fiap.ms.pedidoreceiver.gateway.external;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import br.com.fiap.ms.pedidoreceiver.gateway.external.dto.PagamentoStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PagamentoRestClient implements PagamentoClient {

    private final RestTemplate restTemplate;

    public PagamentoRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean processarPagamento(Pedido pedido) {
        ResponseEntity<PagamentoStatus> response = restTemplate.postForEntity(
                "http://pagamento-service/api/pagamentos",
                pedido,
                PagamentoStatus.class
        );

        // Segurança: verifica se o corpo da resposta não é nulo
        PagamentoStatus status = response.getBody();
        return status != null && status.isAprovado();
    }
}
