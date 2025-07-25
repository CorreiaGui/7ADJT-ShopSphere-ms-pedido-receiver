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

    public String idCliente;
    public List<ItemPedido> itens;
    public String numeroCartao;
    public String status;

}
