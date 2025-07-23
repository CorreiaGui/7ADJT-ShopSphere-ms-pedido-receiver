package br.com.fiap.ms.pedidoreceiver.usecase.impl;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import br.com.fiap.ms.pedidoreceiver.gateway.client.PedidoClient;
import br.com.fiap.ms.pedidoreceiver.usecase.PedidoReceiverUseCase;
import org.springframework.stereotype.Service;

/**
 * Implementação do caso de uso PedidoReceiverUseCase.
 * Processa pedidos recebidos da fila e os envia para o serviço de pedidos.
 */
@Service
public class PedidoReceiverUseCaseImpl implements PedidoReceiverUseCase {

    private final PedidoClient pedidoClient;

    public PedidoReceiverUseCaseImpl(PedidoClient pedidoClient) {
        this.pedidoClient = pedidoClient;
    }

    @Override
    public void processarPedido(Pedido pedido) {
        System.out.println("Processando pedido recebido da fila...");
        pedido.setStatus("ABERTO");
        pedidoClient.enviarPedido(pedido);
    }
}
