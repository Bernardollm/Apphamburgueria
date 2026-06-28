package hamburgueria.app;

import hamburgueria.pedido.Pedido;
import hamburgueria.pedido.StatusPedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaHamburgueriaTest {

    @Test
    void deveCriarSistemaHamburgueria() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        assertNotNull(sistema);
    }

    @Test
    void deveIniciarSistemaSemErro() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        assertDoesNotThrow(sistema::iniciar);
    }

    @Test
    void deveCarregarCardapioInicialSemErro() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        assertDoesNotThrow(sistema::carregarCardapioInicial);
    }

    @Test
    void deveCarregarProdutosNoCardapioInicial() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        sistema.carregarCardapioInicial();

        assertEquals(2, sistema.getCardapio().listarProdutos().size());
    }

    @Test
    void deveRealizarPedidoCompleto() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        Pedido pedido = sistema.realizarPedidoCompleto();

        assertNotNull(pedido);
    }

    @Test
    void pedidoCompletoDeveTerCliente() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        Pedido pedido = sistema.realizarPedidoCompleto();

        assertNotNull(pedido.getCliente());
        assertEquals("João", pedido.getCliente().getNome());
    }

    @Test
    void pedidoCompletoDeveTerItens() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        Pedido pedido = sistema.realizarPedidoCompleto();

        assertFalse(pedido.getItens().isEmpty());
    }

    @Test
    void pedidoCompletoDeveTerTotalMaiorQueZero() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        Pedido pedido = sistema.realizarPedidoCompleto();

        assertTrue(pedido.calcularTotal() > 0);
    }

    @Test
    void pedidoCompletoDeveFicarProntoAposPreparo() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        Pedido pedido = sistema.realizarPedidoCompleto();

        assertEquals(StatusPedido.PRONTO, pedido.getStatus());
    }

    @Test
    void deveRegistrarAcoesNaCentralAtendimento() {
        SistemaHamburgueria sistema = new SistemaHamburgueria();

        sistema.realizarPedidoCompleto();

        assertEquals(3, sistema.getCentralAtendimento().totalAcoesExecutadas());
    }
}