package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public interface RegraPromocao {

    boolean interpretar(Pedido pedido);
}