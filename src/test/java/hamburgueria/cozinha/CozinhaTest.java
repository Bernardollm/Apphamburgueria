package hamburgueria.cozinha;

import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import hamburgueria.pedido.Pedido;
import hamburgueria.pedido.StatusPedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CozinhaTest {

    @Test
    void deveCriarCozinha() {
        Cozinha cozinha = new Cozinha();

        assertNotNull(cozinha);
    }

    @Test
    void cozinhaDeveIniciarComFilaVazia() {
        Cozinha cozinha = new Cozinha();

        assertEquals(0, cozinha.quantidadePedidosNaFila());
    }

    @Test
    void deveReceberPedidoNaFila() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        cozinha.receberPedido(pedido);

        assertEquals(1, cozinha.quantidadePedidosNaFila());
    }

    @Test
    void receberPedidoDeveAvancarStatusParaEmPreparo() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        cozinha.receberPedido(pedido);

        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void devePrepararProximoPedido() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        cozinha.receberPedido(pedido);
        Pedido preparado = cozinha.prepararProximoPedido();

        assertEquals(pedido, preparado);
    }

    @Test
    void prepararPedidoDeveRemoverDaFila() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        cozinha.receberPedido(pedido);
        cozinha.prepararProximoPedido();

        assertEquals(0, cozinha.quantidadePedidosNaFila());
    }

    @Test
    void prepararPedidoDeveAvancarStatusParaPronto() {
        Cozinha cozinha = new Cozinha();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        cozinha.receberPedido(pedido);
        cozinha.prepararProximoPedido();

        assertEquals(StatusPedido.PRONTO, pedido.getStatus());
    }

    @Test
    void naoDevePrepararSemPedidoNaFila() {
        Cozinha cozinha = new Cozinha();

        assertThrows(IllegalStateException.class, cozinha::prepararProximoPedido);
    }

    @Test
    void filaDeveSeguirOrdemDeChegada() {
        Cozinha cozinha = new Cozinha();

        Pedido pedido1 = new Pedido(new Cliente("João", "111"));
        Pedido pedido2 = new Pedido(new Cliente("Maria", "222"));

        cozinha.receberPedido(pedido1);
        cozinha.receberPedido(pedido2);

        assertEquals(pedido1, cozinha.prepararProximoPedido());
        assertEquals(pedido2, cozinha.prepararProximoPedido());
    }

    @Test
    void devePrepararHamburguerDeCarneSemErro() {
        PreparoHamburguer preparo = new PreparoCarne();
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25);

        assertDoesNotThrow(() -> preparo.preparar(hamburguer));
    }

    @Test
    void devePrepararHamburguerVegetarianoSemErro() {
        PreparoHamburguer preparo = new PreparoVegetariano();
        Hamburguer hamburguer = new Hamburguer("Veggie", "Vegetariano", 28);

        assertDoesNotThrow(() -> preparo.preparar(hamburguer));
    }
}