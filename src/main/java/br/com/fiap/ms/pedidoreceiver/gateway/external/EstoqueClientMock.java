package br.com.fiap.ms.pedidoreceiver.gateway.external;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Implementação mock do cliente de estoque.
 * Simula a verificação de disponibilidade de estoque, retornando verdadeiro se todas as quantidades do pedido forem menores ou iguais a 10.
 */
@Primary
@Component
public class EstoqueClientMock implements EstoqueClient {
    @Override
    public boolean verificarDisponibilidade(Pedido pedido) {
        return pedido.getQuantidades().stream().allMatch(q -> q <= 10);
    }
}
