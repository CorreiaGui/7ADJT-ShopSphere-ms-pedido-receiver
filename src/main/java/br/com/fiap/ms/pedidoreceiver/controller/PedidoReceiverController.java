package br.com.fiap.ms.pedidoreceiver.controller;

import br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration;
import br.com.fiap.ms.pedidoreceiver.usecase.CriarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.fiap.ms.pedidoreceiver.utils.PedidoReceiverConstants.PRODUCES;
import static br.com.fiap.ms.pedidoreceiver.utils.PedidoReceiverConstants.V1_PEDIDO_RECEIVER;
import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = V1_PEDIDO_RECEIVER,
                produces = PRODUCES)
public class PedidoReceiverController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public ResponseEntity<String> teste() {
        //log.info("GET | {} | Iniciado criacao de pedido | ", V1_PEDIDO_RECEIVER);
        //String resposta = criarPedidoUseCase.criarPedido();
        //log.info("GET | {} | Finalizada criacao de pedido | clientes: {}", V1_PEDIDO_RECEIVER, "teste");
        rabbitTemplate.convertAndSend(RabbitMqProducerConfiguration.QUEUE_NAME, "teste");
        return ResponseEntity.ok("teste");
    }
}
