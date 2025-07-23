package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;

public interface PedidoReceiverUseCase {
    void processarPedido(Pedido pedido);
}
