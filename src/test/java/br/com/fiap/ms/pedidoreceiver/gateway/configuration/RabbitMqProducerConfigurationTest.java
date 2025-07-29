package br.com.fiap.ms.pedidoreceiver.gateway.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RabbitMqProducerConfigurationTest {

    private RabbitMqProducerConfiguration configuration;

    @BeforeEach
    void setUp() {
        configuration = new RabbitMqProducerConfiguration();
    }

    @Test
    void deveCriarExchangeComNomeCorreto() {
        DirectExchange exchange = configuration.pedidoExchange();
        assertNotNull(exchange);
        assertEquals(RabbitMqProducerConfiguration.EXCHANGE_NAME, exchange.getName());
    }

    @Test
    void deveCriarQueueComNomeCorretoEPersistente() {
        Queue queue = configuration.pedidoQueue();
        assertNotNull(queue);
        assertEquals(RabbitMqProducerConfiguration.QUEUE_NAME, queue.getName());
        assertTrue(queue.isDurable());
    }

    @Test
    void deveCriarBindingComRoutingKeyCorreta() {
        Queue queue = configuration.pedidoQueue();
        DirectExchange exchange = configuration.pedidoExchange();
        Binding binding = configuration.pedidoBinding(queue, exchange);

        assertNotNull(binding);
        assertEquals(RabbitMqProducerConfiguration.ROUTING_KEY, binding.getRoutingKey());
        assertEquals(queue.getName(), binding.getDestination());
        assertEquals(exchange.getName(), binding.getExchange());
    }

    @Test
    void deveCriarJsonMessageConverter() {
        MessageConverter converter = configuration.jsonConverter();
        assertNotNull(converter);
        assertTrue(converter.getClass().getSimpleName().contains("Jackson2JsonMessageConverter"));
    }

    @Test
    void deveCriarRabbitTemplateComMessageConverter() {
        ConnectionFactory connectionFactory = mock(ConnectionFactory.class);
        MessageConverter converter = configuration.jsonConverter();

        RabbitTemplate rabbitTemplate = configuration.rabbitTemplate(connectionFactory, converter);

        assertNotNull(rabbitTemplate);
        assertEquals(converter, rabbitTemplate.getMessageConverter());
    }
}

