package hamburgueria.relatorio;

import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cardapio.Produto;
import hamburgueria.funcionario.Gerente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioTest {

    @Test
    void deveGerarRelatorioDeVendas() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Relatorio relatorio = new RelatorioVendas();

        String resultado = relatorio.gerar(produto);

        assertTrue(resultado.contains("Relatório de vendas"));
    }

    @Test
    void relatorioDeVendasDeveConterNomeProduto() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Relatorio relatorio = new RelatorioVendas();

        assertTrue(relatorio.gerar(produto).contains("X-Burger"));
    }

    @Test
    void deveGerarRelatorioDeLucro() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 40.00);

        Relatorio relatorio = new RelatorioLucro();

        String resultado = relatorio.gerar(produto);

        assertTrue(resultado.contains("Lucro"));
    }

    @Test
    void relatorioDeLucroDeveConterNomeProduto() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 40.00);

        Relatorio relatorio = new RelatorioLucro();

        assertTrue(relatorio.gerar(produto).contains("X-Burger"));
    }

    @Test
    void deveGerarRelatorioDeCalorias() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Relatorio relatorio = new RelatorioCalorias();

        String resultado = relatorio.gerar(produto);

        assertTrue(resultado.contains("Calorias"));
    }

    @Test
    void relatorioDeCaloriasDeveConterKcal() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Relatorio relatorio = new RelatorioCalorias();

        assertTrue(relatorio.gerar(produto).contains("kcal"));
    }

    @Test
    void gerenteDeveGerarRelatorioFinanceiro() {
        Gerente gerente = new Gerente("Carlos");

        RelatorioFinanceiro financeiro =
                new RelatorioFinanceiroRestrito(gerente);

        assertDoesNotThrow(financeiro::gerar);
    }

    @Test
    void relatorioFinanceiroDeveRetornarMensagemDeSucesso() {
        Gerente gerente = new Gerente("Carlos");

        RelatorioFinanceiro financeiro =
                new RelatorioFinanceiroRestrito(gerente);

        assertEquals(
                "Relatório financeiro gerado com sucesso.",
                financeiro.gerar()
        );
    }

    @Test
    void naoDevePermitirGerarRelatorioSemGerente() {
        RelatorioFinanceiro financeiro =
                new RelatorioFinanceiroRestrito(null);

        assertThrows(SecurityException.class, financeiro::gerar);
    }

    @Test
    void produtoDeveAceitarRelatorioDeVendas() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25);

        String resultado =
                produto.aceitarRelatorio(new RelatorioVendas());

        assertNotNull(resultado);
    }

    @Test
    void produtoDeveAceitarRelatorioDeLucro() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25);

        String resultado =
                produto.aceitarRelatorio(new RelatorioLucro());

        assertNotNull(resultado);
    }

    @Test
    void produtoDeveAceitarRelatorioDeCalorias() {
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25);

        String resultado =
                produto.aceitarRelatorio(new RelatorioCalorias());

        assertNotNull(resultado);
    }

}