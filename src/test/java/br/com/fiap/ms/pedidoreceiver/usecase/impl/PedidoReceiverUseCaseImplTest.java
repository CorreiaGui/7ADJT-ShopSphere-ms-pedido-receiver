package br.com.fiap.ms.pedidoreceiver.usecase.impl;

import br.com.fiap.ms.pedidoreceiver.domain.ItemPedido;
import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import br.com.fiap.ms.pedidoreceiver.gateway.client.PedidoClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class PedidoReceiverUseCaseImplTest {

    private PedidoClient pedidoClient;
    private PedidoReceiverUseCaseImpl pedidoReceiverUseCase;

    @BeforeEach
    void setUp() {
        pedidoClient = mock(PedidoClient.class);
        pedidoReceiverUseCase = new PedidoReceiverUseCaseImpl(pedidoClient);
    }

    @Test
    void deveProcessarPedidoComStatusAbertoEChamarPedidoClient() {
        // Arrange
        ItemPedido item1 = new ItemPedido("SKU001", 1);
        ItemPedido item2 = new ItemPedido("SKU002", 2);

        Pedido pedido = new Pedido();
        pedido.setIdCliente("123");
        pedido.setNumeroCartao("4111111111111111");
        pedido.setItens(Arrays.asList(item1, item2));

        // Act
        pedidoReceiverUseCase.processarPedido(pedido);

        // Assert
        verify(pedidoClient, times(1)).enviarPedido(pedido);
        assert "ABERTO".equals(pedido.getStatus());
    }
}
