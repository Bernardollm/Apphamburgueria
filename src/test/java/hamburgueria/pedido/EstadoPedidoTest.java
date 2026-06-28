package hamburgueria.pedido;

import hamburgueria.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoPedidoTest {

    @Test
    void pedidoRecebidoDeveAvancarParaEmPreparo() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();

        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void pedidoEmPreparoDeveAvancarParaPronto() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();

        assertEquals(StatusPedido.PRONTO, pedido.getStatus());
    }

    @Test
    void pedidoProntoDeveAvancarParaSaiuParaEntrega() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();

        assertEquals(StatusPedido.SAIU_PARA_ENTREGA, pedido.getStatus());
    }

    @Test
    void pedidoSaiuParaEntregaDeveAvancarParaEntregue() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();

        assertEquals(StatusPedido.ENTREGUE, pedido.getStatus());
    }

    @Test
    void pedidoEntregueNaoDeveAvancar() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();

        assertThrows(IllegalStateException.class, pedido::avancarStatus);
    }

    @Test
    void pedidoRecebidoPodeSerCancelado() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.cancelar();

        assertEquals(StatusPedido.CANCELADO, pedido.getStatus());
    }

    @Test
    void pedidoEmPreparoPodeSerCancelado() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.cancelar();

        assertEquals(StatusPedido.CANCELADO, pedido.getStatus());
    }

    @Test
    void pedidoProntoNaoPodeSerCancelado() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();

        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    @Test
    void pedidoSaiuParaEntregaNaoPodeSerCancelado() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();
        pedido.avancarStatus();

        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    @Test
    void pedidoCanceladoNaoPodeAvancar() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.cancelar();

        assertThrows(IllegalStateException.class, pedido::avancarStatus);
    }
}