package hamburgueria.atendimento;

import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import hamburgueria.cozinha.Cozinha;
import hamburgueria.pagamento.Pagamento;
import hamburgueria.pagamento.PagamentoPix;
import hamburgueria.pedido.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtendimentoTest {

    @Test
    void deveCriarAtendimento() {
        Atendimento atendimento = new Atendimento("Caixa");

        assertEquals("Caixa", atendimento.getSetor());
    }

    @Test
    void deveEnviarMensagemParaSetor() {
        Atendimento atendimento = new Atendimento("Cozinha");

        String mensagem = atendimento.enviarMensagem("Novo pedido");

        assertEquals("Cozinha recebeu: Novo pedido", mensagem);
    }

    @Test
    void deveCriarPedidoComComando() {
        Cliente cliente = new Cliente("João", "111");
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25);

        CriarPedido comando = new CriarPedido(cliente, hamburguer);

        comando.executar();

        assertNotNull(comando.getPedidoCriado());
    }

    @Test
    void pedidoCriadoDevePertencerAoCliente() {
        Cliente cliente = new Cliente("João", "111");
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25);

        CriarPedido comando = new CriarPedido(cliente, hamburguer);

        comando.executar();

        assertEquals(cliente, comando.getPedidoCriado().getCliente());
    }

    @Test
    void deveCancelarPedido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));

        CancelarPedido comando = new CancelarPedido(pedido);

        comando.executar();

        assertEquals("CANCELADO", pedido.getStatus().name());
    }

    @Test
    void devePagarPedido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X", "Tradicional", 25));

        Pagamento pagamento = new PagamentoPix();

        PagarPedido comando = new PagarPedido(pedido, pagamento);

        assertDoesNotThrow(comando::executar);
    }

    @Test
    void devePrepararPedido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X", "Tradicional", 25));

        Cozinha cozinha = new Cozinha();

        PrepararPedido comando = new PrepararPedido(cozinha, pedido);

        assertDoesNotThrow(comando::executar);
    }

    @Test
    void centralDeveExecutarComando() {
        CentralAtendimento central = new CentralAtendimento();

        Atendimento atendimento = new Atendimento("Caixa");

        AcaoAtendimento comando = () -> atendimento.enviarMensagem("Teste");

        central.executarAcao(comando);

        assertEquals(1, central.totalAcoesExecutadas());
    }

    @Test
    void centralDeveGuardarHistorico() {
        CentralAtendimento central = new CentralAtendimento();

        AcaoAtendimento comando = () -> { };

        central.executarAcao(comando);

        assertEquals(1, central.getHistorico().size());
    }

    @Test
    void deveExecutarMaisDeUmComando() {
        CentralAtendimento central = new CentralAtendimento();

        AcaoAtendimento comando = () -> { };

        central.executarAcao(comando);
        central.executarAcao(comando);
        central.executarAcao(comando);

        assertEquals(3, central.totalAcoesExecutadas());
    }

    @Test
    void historicoNaoDeveEstarVazioAposExecutarComando() {
        CentralAtendimento central = new CentralAtendimento();

        AcaoAtendimento comando = () -> { };

        central.executarAcao(comando);

        assertFalse(central.getHistorico().isEmpty());
    }

    @Test
    void deveExecutarComandoLambda() {
        AcaoAtendimento comando = () -> { };
        assertDoesNotThrow(comando::executar);
    }
}