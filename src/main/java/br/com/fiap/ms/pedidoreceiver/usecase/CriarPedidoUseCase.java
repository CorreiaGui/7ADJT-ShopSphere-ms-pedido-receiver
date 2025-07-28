package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.controller.json.PedidoRequestJson;
import br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration.*;

@Service
public class CriarPedidoUseCase {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void criarPedido(PedidoRequestJson pedidoRequestJson) {
        rabbitTemplate.convertAndSend("exchange", "routingKey", pedidoRequestJson);
    }

}
