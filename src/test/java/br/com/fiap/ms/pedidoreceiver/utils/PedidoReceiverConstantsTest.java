package br.com.fiap.ms.pedidoreceiver.utils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoReceiverConstantsTest {

    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<PedidoReceiverConstants> constructor = PedidoReceiverConstants.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        PedidoReceiverConstants instance = constructor.newInstance();
        assertNotNull(instance);
    }

    @Test
    void testConstants() {
        assertEquals("/api/v1/pedidos", PedidoReceiverConstants.V1_PEDIDO_RECEIVER);
        assertEquals("application/json", PedidoReceiverConstants.PRODUCES);
    }

}
