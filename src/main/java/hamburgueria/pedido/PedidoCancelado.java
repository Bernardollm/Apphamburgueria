package hamburgueria.pedido;

public class PedidoCancelado implements EstadoPedido {

    @Override
    public void proximo(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado não pode avançar.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está cancelado.");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.CANCELADO;
    }
}