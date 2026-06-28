package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public class RegraValorMinimo implements RegraPromocao {

    private double valorMinimo;

    public RegraValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    @Override
    public boolean interpretar(Pedido pedido) {
        return pedido.calcularTotal() >= valorMinimo;
    }
}