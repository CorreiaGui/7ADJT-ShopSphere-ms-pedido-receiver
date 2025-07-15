package br.com.fiap.ms.pedidoreceiver.gateway.queue;

import br.com.fiap.ms.pedidoreceiver.usecase.PedidoReceiverUseCase;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;


/**
 * Listener para receber pedidos da fila RabbitMQ.
 * Processa os pedidos recebidos utilizando o caso de uso PedidoReceiverUseCase.
 */
@Component
public class PedidoReceiverListener {

    private final PedidoReceiverUseCase pedidoReceiverUseCase;

    public PedidoReceiverListener(PedidoReceiverUseCase pedidoReceiverUseCase) {
        this.pedidoReceiverUseCase = pedidoReceiverUseCase;
    }

    /**
     * Método que escuta a fila "pedido.queue" e processa os pedidos recebidos.
     *
     * @param pedido O pedido recebido da fila.
     */
    @RabbitListener(queues = "novo-pedido-queue")
    public void receberPedido(Pedido pedido) {
        System.out.println("Pedido recebido: " + pedido);
        pedidoReceiverUseCase.processarPedido(pedido);
    }



}
