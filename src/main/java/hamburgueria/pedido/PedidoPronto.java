package hamburgueria.pedido;

public class PedidoPronto implements EstadoPedido {

    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoSaiuParaEntrega());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido pronto não pode ser cancelado.");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.PRONTO;
    }
}