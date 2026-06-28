package hamburgueria.entrega;

import hamburgueria.pedido.Pedido;

public class UberEats implements PlataformaDelivery {

    @Override
    public String enviarPedido(Pedido pedido) {
        return "Pedido enviado para o Uber Eats. Total: R$ " + pedido.calcularTotal();
    }
}