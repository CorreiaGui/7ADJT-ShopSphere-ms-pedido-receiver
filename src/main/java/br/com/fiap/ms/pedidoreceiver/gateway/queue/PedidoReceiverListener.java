package br.com.fiap.ms.pedidoreceiver.gateway.queue;

import br.com.fiap.ms.pedidoreceiver.usecase.PedidoReceiverUseCase;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;


/**
 * Listener para receber pedidos da fila RabbitMQ.
 * Processa os pedidos recebidos utilizando o caso de uso PedidoReceiverUseCase.
 */
@Component
public class PedidoReceiverListener {

}
