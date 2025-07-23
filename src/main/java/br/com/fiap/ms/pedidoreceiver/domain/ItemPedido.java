package br.com.fiap.ms.pedidoreceiver.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemPedido {

    private String sku;
    private Integer quantidade;

}
