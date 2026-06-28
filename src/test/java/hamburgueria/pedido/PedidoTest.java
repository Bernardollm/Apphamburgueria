package hamburgueria.pedido;

import hamburgueria.cardapio.Batata;
import hamburgueria.cardapio.Bebida;
import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveCriarPedido() {
        Cliente cliente = new Cliente("João", "11999999999");

        Pedido pedido = new Pedido(cliente);

        assertNotNull(pedido);
    }

    @Test
    void pedidoDevePertencerAoCliente() {
        Cliente cliente = new Cliente("João", "11999999999");

        Pedido pedido = new Pedido(cliente);

        assertEquals(cliente, pedido.getCliente());
    }

    @Test
    void pedidoNovoDeveComecarRecebido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        assertEquals(StatusPedido.RECEBIDO, pedido.getStatus());
    }

    @Test
    void deveAdicionarItemAoPedido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveAdicionarMaisDeUmItem() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));
        pedido.adicionarItem(new Bebida("Refrigerante", "Lata", 7));

        assertEquals(2, pedido.getItens().size());
    }

    @Test
    void deveAdicionarItemComQuantidade() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25), 3);

        assertEquals(1, pedido.getItens().size());
        assertEquals(75.00, pedido.calcularTotal());
    }

    @Test
    void naoDeveAceitarQuantidadeZero() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        assertThrows(
                IllegalArgumentException.class,
                () -> pedido.adicionarItem(
                        new Hamburguer("X", "X", 10),
                        0
                )
        );
    }

    @Test
    void deveCalcularTotalComUmItem() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        assertEquals(25.00, pedido.calcularTotal());
    }

    @Test
    void deveCalcularTotalComVariosItens() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));
        pedido.adicionarItem(new Batata("Batata", "Grande", 15));
        pedido.adicionarItem(new Bebida("Refrigerante", "Lata", 8));

        assertEquals(48.00, pedido.calcularTotal());
    }

    @Test
    void deveAvancarParaEmPreparo() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();

        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void deveAvancarParaPronto() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();

        assertEquals(StatusPedido.PRONTO, pedido.getStatus());
    }

    @Test
    void deveCancelarPedidoRecebido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.cancelar();

        assertEquals(StatusPedido.CANCELADO, pedido.getStatus());
    }

    @Test
    void naoDeveCancelarPedidoPronto() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.avancarStatus();
        pedido.avancarStatus();

        assertThrows(
                IllegalStateException.class,
                pedido::cancelar
        );
    }

    @Test
    void deveSalvarEstadoDoPedido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        PedidoSnapshot snapshot = pedido.salvarEstado();

        assertNotNull(snapshot);
    }

    @Test
    void deveRestaurarEstadoDoPedido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        PedidoSnapshot snapshot = pedido.salvarEstado();

        pedido.avancarStatus();

        pedido.restaurarEstado(snapshot);

        assertEquals(StatusPedido.RECEBIDO, pedido.getStatus());
    }

}