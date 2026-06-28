package hamburgueria.pedido;

public class PedidoEmPreparo implements EstadoPedido {

    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoPronto());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoCancelado());
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.EM_PREPARO;
    }
}