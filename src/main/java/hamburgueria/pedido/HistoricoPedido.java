package hamburgueria.pedido;

import java.util.Stack;

public class HistoricoPedido {

    private Stack<PedidoSnapshot> historico = new Stack<>();

    public void salvar(Pedido pedido) {
        historico.push(pedido.salvarEstado());
    }

    public void desfazer(Pedido pedido) {
        if (!historico.isEmpty()) {
            PedidoSnapshot snapshot = historico.pop();
            pedido.restaurarEstado(snapshot);
        }
    }

    public int quantidadeEstadosSalvos() {
        return historico.size();
    }
}