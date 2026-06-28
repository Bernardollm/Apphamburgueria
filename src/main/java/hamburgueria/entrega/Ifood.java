package hamburgueria.entrega;

import hamburgueria.pedido.Pedido;

public class Ifood implements PlataformaDelivery {

    @Override
    public String enviarPedido(Pedido pedido) {
        return "Pedido enviado para o iFood. Total: R$ " + pedido.calcularTotal();
    }
}