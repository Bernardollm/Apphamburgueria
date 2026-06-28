package hamburgueria.pedido;

public class PedidoRecebido implements EstadoPedido {

    @Override
    public void proximo(Pedido pedido) {
        pedido.setEstado(new PedidoEmPreparo());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoCancelado());
    }

    @Override
    public StatusPedido getStatus() {
        return StatusPedido.RECEBIDO;
    }
}