package hamburgueria.atendimento;

import hamburgueria.pagamento.Pagamento;
import hamburgueria.pedido.Pedido;

public class PagarPedido implements AcaoAtendimento {

    private Pedido pedido;
    private Pagamento pagamento;

    public PagarPedido(Pedido pedido, Pagamento pagamento) {
        this.pedido = pedido;
        this.pagamento = pagamento;
    }

    @Override
    public void executar() {
        pagamento.pagar(pedido.calcularTotal());
    }
}