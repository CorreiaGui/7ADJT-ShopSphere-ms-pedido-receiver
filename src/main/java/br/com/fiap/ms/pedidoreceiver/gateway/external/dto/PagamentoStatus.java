package br.com.fiap.ms.pedidoreceiver.gateway.external.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO que representa o status de um pagamento.
 * Contém informações sobre se o pagamento foi aprovado ou não.
 */
@Getter
@Setter
public class PagamentoStatus {
    private boolean aprovado;

}
