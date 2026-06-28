package hamburgueria.cardapio;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

////Factory Method////


class CardapioTest {

    @Test
    void deveCriarCardapioVazio() {
        Cardapio cardapio = new Cardapio();

        assertTrue(cardapio.listarProdutos().isEmpty());
    }

    @Test
    void deveAdicionarProdutoAoCardapio() {
        Cardapio cardapio = new Cardapio();
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25.00);

        cardapio.adicionarProduto(produto);

        assertEquals(1, cardapio.listarProdutos().size());
    }

    @Test
    void deveListarProdutosDoCardapio() {
        Cardapio cardapio = new Cardapio();
        cardapio.adicionarProduto(new Hamburguer("X-Burger", "Tradicional", 25.00));
        cardapio.adicionarProduto(new Bebida("Refrigerante", "Lata", 7.00));

        List<Produto> produtos = cardapio.listarProdutos();

        assertEquals(2, produtos.size());
    }

    @Test
    void deveBuscarProdutoPorNome() {
        Cardapio cardapio = new Cardapio();
        Produto produto = new Hamburguer("X-Burger", "Tradicional", 25.00);

        cardapio.adicionarProduto(produto);

        assertEquals(produto, cardapio.buscarProduto("X-Burger"));
    }

    @Test
    void deveBuscarProdutoIgnorandoMaiusculasMinusculas() {
        Cardapio cardapio = new Cardapio();
        Produto produto = new Hamburguer("X-Bacon", "Com bacon", 30.00);

        cardapio.adicionarProduto(produto);

        assertEquals(produto, cardapio.buscarProduto("x-bacon"));
    }

    @Test
    void deveRetornarNullQuandoProdutoNaoExistir() {
        Cardapio cardapio = new Cardapio();

        assertNull(cardapio.buscarProduto("Produto inexistente"));
    }

    @Test
    void deveCriarHamburguerPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Produto produto = fabrica.criarProduto("hamburguer", "X-Burger", "Tradicional", 25.00);

        assertInstanceOf(Hamburguer.class, produto);
    }

    @Test
    void deveCriarBebidaPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Produto produto = fabrica.criarProduto("bebida", "Refrigerante", "Lata", 7.00);

        assertInstanceOf(Bebida.class, produto);
    }

    @Test
    void deveCriarBatataPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Produto produto = fabrica.criarProduto("batata", "Batata Média", "Porção média", 12.00);

        assertInstanceOf(Batata.class, produto);
    }

    @Test
    void deveCriarSobremesaPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Produto produto = fabrica.criarProduto("sobremesa", "Brownie", "Chocolate", 15.00);

        assertInstanceOf(Sobremesa.class, produto);
    }

    @Test
    void naoDeveCriarProdutoComTipoInvalido() {
        FabricaCardapio fabrica = new FabricaCardapio();

        assertThrows(
                IllegalArgumentException.class,
                () -> fabrica.criarProduto("pizza", "Pizza", "Inexistente", 40.00)
        );
    }
}