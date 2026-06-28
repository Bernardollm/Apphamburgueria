package hamburgueria.entrega;

import hamburgueria.pedido.Pedido;

public class Rappi implements PlataformaDelivery {

    @Override
    public String enviarPedido(Pedido pedido) {
        return "Pedido enviado para o Rappi. Total: R$ " + pedido.calcularTotal();
    }
}