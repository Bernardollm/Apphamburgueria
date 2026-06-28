package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public class PromocaoDia extends Promocao {

    @Override
    protected double calcularDesconto(Pedido pedido) {
        if (pedido.calcularTotal() >= 50) {
            return 5.00;
        }

        return 0;
    }
}