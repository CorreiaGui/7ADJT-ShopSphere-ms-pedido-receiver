package br.com.fiap.ms.pedidoreceiver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class PedidoReceiverApplicationTest {

    @Test
    void contextLoads() {
    }

    @Test
    void mainMethodShouldRunWithoutErrors() {
        assertDoesNotThrow(() ->
                PedidoReceiverApplication.main(new String[]{})
        );
    }
}
