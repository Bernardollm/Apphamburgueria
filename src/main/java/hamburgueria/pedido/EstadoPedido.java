package hamburgueria.pedido;

public interface EstadoPedido {

    void proximo(Pedido pedido);

    void cancelar(Pedido pedido);

    StatusPedido getStatus();
}