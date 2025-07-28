package br.com.fiap.ms.pedidoreceiver.controller;

import br.com.fiap.ms.pedidoreceiver.controller.json.PedidoRequestJson;
import br.com.fiap.ms.pedidoreceiver.usecase.CriarPedidoUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.fiap.ms.pedidoreceiver.utils.PedidoReceiverConstants.PRODUCES;
import static br.com.fiap.ms.pedidoreceiver.utils.PedidoReceiverConstants.V1_PEDIDO_RECEIVER;

@Slf4j
@RestController
@RequestMapping(value = V1_PEDIDO_RECEIVER,
                produces = PRODUCES)
public class PedidoReceiverController {

    @Autowired
    private CriarPedidoUseCase criarPedidoUseCase;

    @PostMapping
    public ResponseEntity criarPedido(@RequestBody PedidoRequestJson pedidoRequest){
        criarPedidoUseCase.criarPedido(pedidoRequest);
        return ResponseEntity.ok().build();
    }

}
