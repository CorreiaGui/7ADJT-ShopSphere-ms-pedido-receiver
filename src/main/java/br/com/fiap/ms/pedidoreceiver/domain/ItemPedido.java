package br.com.fiap.ms.pedidoreceiver.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemPedido {

    private UUID id;

    private Integer numeroPedido;

    private String sku;

    private Integer quantidade;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataUltimaAlteracao;
}
