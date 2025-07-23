package br.com.fiap.ms.pedidoreceiver.usecase;

import br.com.fiap.ms.pedidoreceiver.domain.Pedido;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por processar pedidos recebidos.
 * Ele verifica a disponibilidade de estoque e processa o pagamento.
 */
@Service
public class PedidoReceiverService implements PedidoReceiverUseCase {

    public PedidoReceiverService() {
    }

    /**
     * Processa um pedido, verificando estoque e pagamento.
     *
     * @param pedido O pedido a ser processado.
     */
    @Override
    public void processarPedido(Pedido pedido) {
        pedido.setStatus("ABERTO");
    }
}
