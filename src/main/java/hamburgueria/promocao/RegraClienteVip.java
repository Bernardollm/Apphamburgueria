package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public class RegraClienteVip implements RegraPromocao {

    @Override
    public boolean interpretar(Pedido pedido) {
        return pedido.getCliente().isVip();
    }
}