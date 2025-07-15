package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import br.com.fiap.ms.pedidoreceiver.gateway.external.EstoqueClient;
import br.com.fiap.ms.pedidoreceiver.gateway.external.PagamentoClient;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por processar pedidos recebidos.
 * Ele verifica a disponibilidade de estoque e processa o pagamento.
 */
@Service
public class PedidoReceiverService implements PedidoReceiverUseCase {

    private final PagamentoClient pagamentoClient;
    private final EstoqueClient estoqueClient;

    public PedidoReceiverService(PagamentoClient pagamentoClient, EstoqueClient estoqueClient) {
        this.pagamentoClient = pagamentoClient;
        this.estoqueClient = estoqueClient;
    }

    /**
     * Processa um pedido, verificando estoque e pagamento.
     *
     * @param pedido O pedido a ser processado.
     */
    @Override
    public void processarPedido(Pedido pedido) {
        pedido.setStatus("ABERTO");

        boolean estoqueDisponivel = estoqueClient.verificarDisponibilidade(pedido);
        if (!estoqueDisponivel) {
            pedido.setStatus("FECHADO_SEM_ESTOQUE");
            System.out.println("Estoque insuficiente para o pedido: " + pedido);
            return;
        }

        boolean pagamentoAutorizado = pagamentoClient.processarPagamento(pedido);
        if (pagamentoAutorizado) {
            pedido.setStatus("FECHADO_COM_SUCESSO");
        } else {
            pedido.setStatus("FECHADO_SEM_CREDITO");
        }

        System.out.println("Pedido finalizado: " + pedido);
    }
}
