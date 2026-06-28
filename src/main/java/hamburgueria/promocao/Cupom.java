package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public class Cupom extends Promocao {

    private String codigo;

    public Cupom(String codigo) {
        this.codigo = codigo;
    }

    @Override
    protected double calcularDesconto(Pedido pedido) {
        if ("BURGER10".equalsIgnoreCase(codigo)) {
            return pedido.calcularTotal() * 0.10;
        }

        return 0;
    }
}