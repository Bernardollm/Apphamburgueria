package hamburgueria.pedido;

import java.util.List;

public class PedidoSnapshot {

    private final StatusPedido status;
    private final List<ItemPedido> itens;

    public PedidoSnapshot(StatusPedido status, List<ItemPedido> itens) {
        this.status = status;
        this.itens = itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}