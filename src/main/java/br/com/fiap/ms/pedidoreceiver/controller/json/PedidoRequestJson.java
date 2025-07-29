package br.com.fiap.ms.pedidoreceiver.controller.json;

import java.util.List;

public record PedidoRequestJson(String documentoCliente,
                                List<ItemPedidoRequestJson> itens,
                                Integer formaPagamento,
                                String numeroCartaoCredito) {
}
