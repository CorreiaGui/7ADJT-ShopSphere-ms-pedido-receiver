package br.com.fiap.ms.pedidoreceiver.gateway.queue;

import br.com.fiap.ms.pedidoreceiver.domain.ItemPedido;
import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import br.com.fiap.ms.pedidoreceiver.usecase.PedidoReceiverUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class PedidoReceiverListenerTest {

    private PedidoReceiverUseCase pedidoReceiverUseCase;
    private PedidoReceiverListener pedidoReceiverListener;

    @BeforeEach
    void setUp() {
        pedidoReceiverUseCase = mock(PedidoReceiverUseCase.class);
        pedidoReceiverListener = new PedidoReceiverListener(pedidoReceiverUseCase);
    }

    @Test
    void deveReceberEPassarPedidoParaUseCase() {
        // Arrange
        ItemPedido item1 = new ItemPedido("ABC123", 2);
        ItemPedido item2 = new ItemPedido("XYZ789", 1);

        Pedido pedido = new Pedido();
        pedido.setIdCliente("123");
        pedido.setNumeroCartao("4111111111111111");
        pedido.setStatus("ABERTO");
        pedido.setItens(Arrays.asList(item1, item2));

        // Act
        pedidoReceiverListener.receberPedido(pedido);

        // Assert
        verify(pedidoReceiverUseCase, times(1)).processarPedido(pedido);
    }
}
