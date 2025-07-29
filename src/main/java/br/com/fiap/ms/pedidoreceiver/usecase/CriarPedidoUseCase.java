package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.controller.json.PedidoRequestJson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration.EXCHANGE_NAME;
import static br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration.ROUTING_KEY;

@Service
public class CriarPedidoUseCase {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void criarPedido(PedidoRequestJson pedidoRequestJson) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, pedidoRequestJson);
    }

}
