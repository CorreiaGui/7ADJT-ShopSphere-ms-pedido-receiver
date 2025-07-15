package br.com.fiap.ms.pedidoreceiver.gateway.external;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;

/**
 * Interface para o cliente de estoque.
 * Define o contrato para verificar a disponibilidade de estoque para pedidos.
 */
public interface EstoqueClient {
    boolean verificarDisponibilidade(Pedido pedido);
}
