package br.com.fiap.ms.pedidoreceiver.gateway.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitMqProducerConfiguration {

    public static final String QUEUE_NAME = "novo-pedido-queue";
    public static final String EXCHANGE_NAME = "pedido-exchange";
    public static final String ROUTING_KEY = "criar-pedido";

    @Bean
    public DirectExchange pedidoExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue pedidoQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding pedidoBinding(Queue pedidoQueue, DirectExchange pedidoExchange) {
        return BindingBuilder.bind(pedidoQueue).to(pedidoExchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter jsonConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonConverter);
        return template;
    }
}
