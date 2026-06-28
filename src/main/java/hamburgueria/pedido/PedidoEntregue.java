package hamburgueria.pedido;

public class PedidoEntregue implements EstadoPedido {

    @Override
    public void proximo(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido entregue não pode ser cancelado.");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.ENTREGUE;
    }
}