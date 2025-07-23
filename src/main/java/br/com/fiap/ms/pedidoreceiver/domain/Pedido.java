package br.com.fiap.ms.pedidoreceiver.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pedido implements Serializable {

    private String idCliente;
    private List<ItemPedido> itens;
    private String numeroCartao;
    private String status;

}
