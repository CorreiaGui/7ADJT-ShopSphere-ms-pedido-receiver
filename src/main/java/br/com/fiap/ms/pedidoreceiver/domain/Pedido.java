package br.com.fiap.ms.pedidoreceiver.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pedido {

    private UUID id;

    private Integer numeroPedido;

    private String cpf;

    private BigDecimal valorTotal;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataUltimaAlteracao;

    private List<ItemPedido> itens;

    private UUID pagamentoId;

    private StatusPedido status;

}
