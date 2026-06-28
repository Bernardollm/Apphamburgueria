package hamburgueria.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

////Prototype////


class ProdutoTest {

    @Test
    void deveCriarProduto() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        assertNotNull(produto);
    }

    @Test
    void deveRetornarNomeCorretamente() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        assertEquals("X-Burger", produto.getNome());
    }

    @Test
    void deveRetornarDescricaoCorretamente() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        assertEquals("Hambúrguer tradicional", produto.getDescricao());
    }

    @Test
    void deveRetornarPrecoCorretamente() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        assertEquals(25.00, produto.getPreco());
    }

    @Test
    void deveAlterarPreco() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        produto.setPreco(30.00);

        assertEquals(30.00, produto.getPreco());
    }

    @Test
    void deveClonarProduto() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        Produto clone = produto.clonar();

        assertNotSame(produto, clone);
    }

    @Test
    void cloneDeveTerMesmoNome() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        Produto clone = produto.clonar();

        assertEquals(produto.getNome(), clone.getNome());
    }

    @Test
    void cloneDeveTerMesmoPreco() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        Produto clone = produto.clonar();

        assertEquals(produto.getPreco(), clone.getPreco());
    }

    @Test
    void toStringDeveConterNomeDoProduto() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        assertTrue(produto.toString().contains("X-Burger"));
    }

    @Test
    void toStringDeveConterPrecoDoProduto() {
        Produto produto = new Hamburguer(
                "X-Burger",
                "Hambúrguer tradicional",
                25.00
        );

        assertTrue(produto.toString().contains("25"));
    }

}