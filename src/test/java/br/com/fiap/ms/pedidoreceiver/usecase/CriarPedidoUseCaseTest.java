package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.controller.json.PedidoRequestJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Collections;

import static br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration.EXCHANGE_NAME;
import static br.com.fiap.ms.pedidoreceiver.gateway.configuration.RabbitMqProducerConfiguration.ROUTING_KEY;
import static org.mockito.Mockito.*;

class CriarPedidoUseCaseTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private CriarPedidoUseCase criarPedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveEnviarPedidoParaRabbitMQ() {
        PedidoRequestJson pedido = new PedidoRequestJson(
                "123",
                Collections.emptyList(),
                1,
                "obs"
        );

        criarPedidoUseCase.criarPedido(pedido);

        verify(rabbitTemplate, times(1))
                .convertAndSend(EXCHANGE_NAME, ROUTING_KEY, pedido);
    }
}

