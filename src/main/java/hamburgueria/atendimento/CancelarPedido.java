package hamburgueria.atendimento;

import hamburgueria.pedido.Pedido;

public class CancelarPedido implements AcaoAtendimento {

    private Pedido pedido;

    public CancelarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        pedido.cancelar();
    }
}