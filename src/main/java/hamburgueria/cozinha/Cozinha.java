package hamburgueria.cozinha;

import hamburgueria.pedido.Pedido;

public class Cozinha {

    private final FilaPreparo filaPreparo;

    public Cozinha() {
        this.filaPreparo = new FilaPreparo();
    }

    public void receberPedido(Pedido pedido) {
        filaPreparo.adicionarPedido(pedido);
        pedido.avancarStatus();
    }

    public Pedido prepararProximoPedido() {
        Pedido pedido = filaPreparo.proximoPedido();

        if (pedido == null) {
            throw new IllegalStateException("Não há pedidos na fila.");
        }

        pedido.avancarStatus();
        return pedido;
    }

    public int quantidadePedidosNaFila() {
        return filaPreparo.tamanho();
    }
}