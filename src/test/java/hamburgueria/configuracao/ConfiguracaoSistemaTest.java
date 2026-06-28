package hamburgueria.configuracao;

import hamburgueria.cardapio.Hamburguer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

////Singleton////

class ConfiguracaoSistemaTest {

    @BeforeEach
    void limparBanco() {
        BancoDados.getInstancia().limpar();
    }

    @Test
    void configuracaoSistemaDeveSerSingleton() {
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstancia();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstancia();

        assertSame(config1, config2);
    }

    @Test
    void bancoDadosDeveSerSingleton() {
        BancoDados banco1 = BancoDados.getInstancia();
        BancoDados banco2 = BancoDados.getInstancia();

        assertSame(banco1, banco2);
    }

    @Test
    void deveAlterarNomeDoSistema() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();

        config.setNomeSistema("Hamburgueria Premium");

        assertEquals("Hamburgueria Premium", config.getNomeSistema());
    }

    @Test
    void deveAlterarTaxaDeServico() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();

        config.setTaxaServico(0.15);

        assertEquals(0.15, config.getTaxaServico());
    }

    @Test
    void naoDevePermitirTaxaNegativa() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();

        assertThrows(
                IllegalArgumentException.class,
                () -> config.setTaxaServico(-0.10)
        );
    }

    @Test
    void deveAlterarStatusDoDelivery() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();

        config.setDeliveryAtivo(false);

        assertFalse(config.isDeliveryAtivo());
    }

    @Test
    void deveSalvarObjetoNoBanco() {
        BancoDados banco = BancoDados.getInstancia();

        banco.salvar(new Hamburguer("X-Burger", "Tradicional", 25));

        assertEquals(1, banco.totalRegistros());
    }

    @Test
    void deveSalvarMaisDeUmObjetoNoBanco() {
        BancoDados banco = BancoDados.getInstancia();

        banco.salvar(new Hamburguer("X-Burger", "Tradicional", 25));
        banco.salvar(new Hamburguer("X-Bacon", "Especial", 30));

        assertEquals(2, banco.totalRegistros());
    }

    @Test
    void naoDeveSalvarObjetoNulo() {
        BancoDados banco = BancoDados.getInstancia();

        assertThrows(
                IllegalArgumentException.class,
                () -> banco.salvar(null)
        );
    }

    @Test
    void deveLimparBanco() {
        BancoDados banco = BancoDados.getInstancia();

        banco.salvar(new Hamburguer("X-Burger", "Tradicional", 25));
        banco.limpar();

        assertEquals(0, banco.totalRegistros());
    }

    @Test
    void listarRegistrosDeveRetornarLista() {
        BancoDados banco = BancoDados.getInstancia();

        banco.salvar(new Hamburguer("X-Burger", "Tradicional", 25));

        assertEquals(1, banco.listarRegistros().size());
    }

    @Test
    void deliveryDeveIniciarAtivado() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();

        config.setDeliveryAtivo(true);

        assertTrue(config.isDeliveryAtivo());
    }
}