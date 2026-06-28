package hamburgueria.atendimento;

import hamburgueria.cozinha.Cozinha;
import hamburgueria.pedido.Pedido;

public class PrepararPedido implements AcaoAtendimento {

    private Cozinha cozinha;
    private Pedido pedido;

    public PrepararPedido(Cozinha cozinha, Pedido pedido) {
        this.cozinha = cozinha;
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        cozinha.receberPedido(pedido);
        cozinha.prepararProximoPedido();
    }
}