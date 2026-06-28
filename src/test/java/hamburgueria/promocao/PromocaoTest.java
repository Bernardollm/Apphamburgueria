package hamburgueria.promocao;

import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import hamburgueria.cliente.ClienteVip;
import hamburgueria.pedido.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromocaoTest {

    @Test
    void deveAplicarCupomBurger10() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 100));

        Cupom cupom = new Cupom("BURGER10");

        assertEquals(10.00, cupom.aplicar(pedido));
    }

    @Test
    void naoDeveAplicarCupomInvalido() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 100));

        Cupom cupom = new Cupom("INVALIDO");

        assertEquals(0.00, cupom.aplicar(pedido));
    }

    @Test
    void deveAplicarPromocaoDoDia() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 50));

        PromocaoDia promocao = new PromocaoDia();

        assertEquals(5.00, promocao.aplicar(pedido));
    }

    @Test
    void naoDeveAplicarPromocaoDoDiaAbaixoDe50() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 40));

        PromocaoDia promocao = new PromocaoDia();

        assertEquals(0.00, promocao.aplicar(pedido));
    }

    @Test
    void deveAplicarDescontoClienteVip() {
        Pedido pedido = new Pedido(new ClienteVip("Maria", "222", 0.20));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 100));

        PromocaoClienteVip promocao = new PromocaoClienteVip();

        assertEquals(20.00, promocao.aplicar(pedido));
    }

    @Test
    void naoDeveAplicarVipParaClienteComum() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 100));

        PromocaoClienteVip promocao = new PromocaoClienteVip();

        assertEquals(0.00, promocao.aplicar(pedido));
    }

    @Test
    void deveAplicarAutorizacaoGerente() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 100));

        AutorizacaoGerente autorizacao = new AutorizacaoGerente(true);

        assertEquals(15.00, autorizacao.aplicar(pedido));
    }

    @Test
    void naoDeveAplicarAutorizacaoGerenteSemPermissao() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 100));

        AutorizacaoGerente autorizacao = new AutorizacaoGerente(false);

        assertEquals(0.00, autorizacao.aplicar(pedido));
    }

    @Test
    void cadeiaDePromocoesDeveAplicarPrimeiraValida() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 60));

        Promocao promocao = new Cupom("INVALIDO");
        promocao.ligarCom(new PromocaoDia());

        assertEquals(5.00, promocao.aplicar(pedido));
    }

    @Test
    void regraClienteVipDeveInterpretarClienteVip() {
        Pedido pedido = new Pedido(new ClienteVip("Maria", "222", 0.10));

        RegraPromocao regra = new RegraClienteVip();

        assertTrue(regra.interpretar(pedido));
    }

    @Test
    void regraValorMinimoDeveInterpretarValorSuficiente() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 80));

        RegraPromocao regra = new RegraValorMinimo(50);

        assertTrue(regra.interpretar(pedido));
    }

    @Test
    void regraCompostaDeveInterpretarDuasRegrasVerdadeiras() {
        Pedido pedido = new Pedido(new ClienteVip("Maria", "222", 0.10));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 80));

        RegraPromocao regra = new RegraComposta(
                new RegraClienteVip(),
                new RegraValorMinimo(50)
        );

        assertTrue(regra.interpretar(pedido));
    }
}