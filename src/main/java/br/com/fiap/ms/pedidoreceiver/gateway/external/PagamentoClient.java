package br.com.fiap.ms.pedidoreceiver.gateway.external;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;

/**
 * Interface para o cliente de pagamento.
 * Define o contrato para processar pagamentos de pedidos.
 */
public interface PagamentoClient {
    boolean processarPagamento(Pedido pedido);
}
