package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public class AutorizacaoGerente extends Promocao {

    private boolean autorizado;

    public AutorizacaoGerente(boolean autorizado) {
        this.autorizado = autorizado;
    }

    @Override
    protected double calcularDesconto(Pedido pedido) {
        if (autorizado && pedido.calcularTotal() >= 100) {
            return pedido.calcularTotal() * 0.15;
        }

        return 0;
    }
}