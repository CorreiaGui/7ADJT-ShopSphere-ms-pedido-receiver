package br.com.fiap.ms.pedidoreceiver.gateway.external;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Implementação mock do cliente de pagamento.
 * Simula o processamento de pagamento, retornando verdadeiro se o valor total do pedido for menor ou igual a 1000.
 */
@Primary
@Component
public class PagamentoClientMock implements PagamentoClient {

    @Override
    public boolean processarPagamento(Pedido pedido) {
        return pedido.getValorTotal() <= 1000.0;
    }
}
