package br.com.fiap.ms.pedidoreceiver.controller;

import br.com.fiap.ms.pedidoreceiver.controller.json.ItemPedidoRequestJson;
import br.com.fiap.ms.pedidoreceiver.controller.json.PedidoRequestJson;
import br.com.fiap.ms.pedidoreceiver.usecase.CriarPedidoUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PedidoReceiverControllerTest {

    @Mock
    private CriarPedidoUseCase criarPedidoUseCase;

    @InjectMocks
    private PedidoReceiverController controller;

    public PedidoReceiverControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarPedidoComSucesso() {
        ItemPedidoRequestJson itemPedidoRequestJson =
                new ItemPedidoRequestJson("JAQUETA-PP", 10L);

        PedidoRequestJson pedidoRequest =
                new PedidoRequestJson("1", Collections.singletonList(itemPedidoRequestJson), 1, "");

        ResponseEntity response = controller.criarPedido(pedidoRequest);

        verify(criarPedidoUseCase, times(1)).criarPedido(pedidoRequest);
        assertEquals(200, response.getStatusCodeValue());
    }
}
