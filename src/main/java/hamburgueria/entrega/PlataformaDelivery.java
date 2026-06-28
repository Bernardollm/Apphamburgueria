package hamburgueria.entrega;

import hamburgueria.pedido.Pedido;

public interface PlataformaDelivery {

    String enviarPedido(Pedido pedido);
}