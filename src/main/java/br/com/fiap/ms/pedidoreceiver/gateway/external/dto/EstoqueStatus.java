package br.com.fiap.ms.pedidoreceiver.gateway.external.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO que representa o status de disponibilidade de estoque.
 * Utilizado para verificar se um produto está disponível em estoque.
 */
@Setter
@Getter
public class EstoqueStatus {

    private boolean disponivel;

}
