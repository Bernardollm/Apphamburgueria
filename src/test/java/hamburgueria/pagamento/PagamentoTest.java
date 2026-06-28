package hamburgueria.pagamento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    @Test
    void deveRealizarPagamentoPix() {
        Pagamento pagamento = new PagamentoPix();

        assertTrue(pagamento.pagar(50.00));
    }

    @Test
    void naoDevePermitirPagamentoPixComValorZero() {
        Pagamento pagamento = new PagamentoPix();

        assertThrows(
                IllegalArgumentException.class,
                () -> pagamento.pagar(0)
        );
    }

    @Test
    void deveRealizarPagamentoComCartao() {
        Pagamento pagamento = new PagamentoCartao("1234567890123456");

        assertTrue(pagamento.pagar(80.00));
    }

    @Test
    void naoDeveAceitarNumeroCartaoInvalido() {
        Pagamento pagamento = new PagamentoCartao("123");

        assertThrows(
                IllegalArgumentException.class,
                () -> pagamento.pagar(80.00)
        );
    }

    @Test
    void naoDeveAceitarValorNegativoNoCartao() {
        Pagamento pagamento = new PagamentoCartao("1234567890123456");

        assertThrows(
                IllegalArgumentException.class,
                () -> pagamento.pagar(-20)
        );
    }

    @Test
    void deveRealizarPagamentoEmDinheiro() {
        PagamentoDinheiro pagamento = new PagamentoDinheiro(100);

        assertTrue(pagamento.pagar(70));
    }

    @Test
    void deveCalcularTrocoCorretamente() {
        PagamentoDinheiro pagamento = new PagamentoDinheiro(100);

        assertEquals(30.00, pagamento.calcularTroco(70));
    }

    @Test
    void naoDeveAceitarDinheiroInsuficiente() {
        PagamentoDinheiro pagamento = new PagamentoDinheiro(50);

        assertThrows(
                IllegalArgumentException.class,
                () -> pagamento.pagar(70)
        );
    }

    @Test
    void deveRealizarPagamentoComValeAlimentacao() {
        PagamentoValeAlimentacao pagamento =
                new PagamentoValeAlimentacao(200);

        assertTrue(pagamento.pagar(80));
    }

    @Test
    void deveAtualizarSaldoDoValeAlimentacao() {
        PagamentoValeAlimentacao pagamento =
                new PagamentoValeAlimentacao(200);

        pagamento.pagar(80);

        assertEquals(120.00, pagamento.getSaldo());
    }

    @Test
    void naoDevePermitirSaldoInsuficienteNoVale() {
        PagamentoValeAlimentacao pagamento =
                new PagamentoValeAlimentacao(30);

        assertThrows(
                IllegalArgumentException.class,
                () -> pagamento.pagar(50)
        );
    }

    @Test
    void todasAsFormasDePagamentoImplementamInterface() {

        assertInstanceOf(Pagamento.class, new PagamentoPix());
        assertInstanceOf(Pagamento.class, new PagamentoCartao("1234567890123456"));
        assertInstanceOf(Pagamento.class, new PagamentoDinheiro(100));
        assertInstanceOf(Pagamento.class, new PagamentoValeAlimentacao(200));
    }

}