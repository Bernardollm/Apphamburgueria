package hamburgueria.pedido;

public class PedidoSaiuParaEntrega implements EstadoPedido {

    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido em entrega não pode ser cancelado.");
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.SAIU_PARA_ENTREGA;
    }
}