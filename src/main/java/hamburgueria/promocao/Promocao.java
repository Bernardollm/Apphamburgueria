package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public abstract class Promocao {

    private Promocao proxima;

    public Promocao ligarCom(Promocao proxima) {
        this.proxima = proxima;
        return proxima;
    }

    public double aplicar(Pedido pedido) {
        double desconto = calcularDesconto(pedido);

        if (desconto > 0) {
            return desconto;
        }

        if (proxima != null) {
            return proxima.aplicar(pedido);
        }

        return 0;
    }

    protected abstract double calcularDesconto(Pedido pedido);
}