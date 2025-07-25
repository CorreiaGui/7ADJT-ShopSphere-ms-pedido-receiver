package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.gateway.PedidoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class CriarPedidoUseCase {

    //private final PedidoGateway pedidoGateway;

    public String criarPedido() {
        return "";//return pedidoGateway.criarPedido();
    }
}
