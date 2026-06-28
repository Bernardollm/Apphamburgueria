package hamburgueria.atendimento;

import hamburgueria.cardapio.ItemCardapio;
import hamburgueria.cliente.Cliente;
import hamburgueria.pedido.Pedido;

public class CriarPedido implements AcaoAtendimento {

    private Cliente cliente;
    private ItemCardapio item;
    private Pedido pedidoCriado;

    public CriarPedido(Cliente cliente, ItemCardapio item) {
        this.cliente = cliente;
        this.item = item;
    }

    @Override
    public void executar() {
        pedidoCriado = new Pedido(cliente);
        pedidoCriado.adicionarItem(item);
    }

    public Pedido getPedidoCriado() {
        return pedidoCriado;
    }
}