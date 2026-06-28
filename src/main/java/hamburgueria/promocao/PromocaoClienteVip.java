package hamburgueria.promocao;

import hamburgueria.cliente.ClienteVip;
import hamburgueria.pedido.Pedido;

public class PromocaoClienteVip extends Promocao {

    @Override
    protected double calcularDesconto(Pedido pedido) {
        if (pedido.getCliente() instanceof ClienteVip clienteVip) {
            return pedido.calcularTotal() * clienteVip.getPercentualDesconto();
        }

        return 0;
    }
}