package hamburgueria.cozinha;

import hamburgueria.pedido.Pedido;

import java.util.LinkedList;
import java.util.Queue;

public class FilaPreparo {

    private final Queue<Pedido> pedidos = new LinkedList<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Pedido proximoPedido() {
        return pedidos.poll();
    }

    public int tamanho() {
        return pedidos.size();
    }

    public boolean estaVazia() {
        return pedidos.isEmpty();
    }
}