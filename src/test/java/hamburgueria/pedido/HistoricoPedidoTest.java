package hamburgueria.pedido;

import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoPedidoTest {

    @Test
    void deveCriarHistoricoVazio() {
        HistoricoPedido historico = new HistoricoPedido();

        assertEquals(0, historico.quantidadeEstadosSalvos());
    }

    @Test
    void deveSalvarEstadoDoPedido() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        historico.salvar(pedido);

        assertEquals(1, historico.quantidadeEstadosSalvos());
    }

    @Test
    void deveSalvarMaisDeUmEstado() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        historico.salvar(pedido);

        pedido.avancarStatus();

        historico.salvar(pedido);

        assertEquals(2, historico.quantidadeEstadosSalvos());
    }

    @Test
    void deveRestaurarPedidoRecebido() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        historico.salvar(pedido);

        pedido.avancarStatus();

        historico.desfazer(pedido);

        assertEquals(StatusPedido.RECEBIDO, pedido.getStatus());
    }

    @Test
    void desfazerDeveRemoverEstadoDoHistorico() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        historico.salvar(pedido);

        historico.desfazer(pedido);

        assertEquals(0, historico.quantidadeEstadosSalvos());
    }

    @Test
    void desfazerHistoricoVazioNaoDeveLancarExcecao() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        assertDoesNotThrow(() -> historico.desfazer(pedido));
    }

    @Test
    void deveRestaurarItensDoPedido() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        historico.salvar(pedido);

        pedido.adicionarItem(new Hamburguer("X-Bacon", "Especial", 30));

        historico.desfazer(pedido);

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveSalvarPedidoComItens() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        historico.salvar(pedido);

        assertEquals(1, historico.quantidadeEstadosSalvos());
    }

    @Test
    void devePermitirSalvarMesmoEstadoMaisDeUmaVez() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        historico.salvar(pedido);
        historico.salvar(pedido);

        assertEquals(2, historico.quantidadeEstadosSalvos());
    }

    @Test
    void deveRestaurarUltimoEstadoSalvo() {
        HistoricoPedido historico = new HistoricoPedido();
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        historico.salvar(pedido);

        pedido.avancarStatus();

        historico.salvar(pedido);

        pedido.avancarStatus();

        historico.desfazer(pedido);

        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

}