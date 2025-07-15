package br.com.fiap.ms.pedidoreceiver.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString // Para ver todos os campos no log
public class Pedido implements Serializable {
    private String idCliente;
    private List<String> skus;
    private List<Integer> quantidades;
    private String numeroCartao;
    private Double valorTotal;
    private String status;

}
