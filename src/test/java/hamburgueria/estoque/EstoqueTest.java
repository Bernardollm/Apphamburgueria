package hamburgueria.estoque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    @Test
    void deveCriarIngrediente() {
        Ingrediente ingrediente = new Ingrediente("Queijo", "unidade");

        assertEquals("Queijo", ingrediente.getNome());
        assertEquals("unidade", ingrediente.getUnidadeMedida());
    }

    @Test
    void deveAdicionarIngredienteAoEstoque() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        estoque.adicionarIngrediente(queijo, 10);

        assertEquals(10, estoque.consultarQuantidade(queijo));
    }

    @Test
    void deveSomarQuantidadeAoAdicionarMesmoIngrediente() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        estoque.adicionarIngrediente(queijo, 10);
        estoque.adicionarIngrediente(queijo, 5);

        assertEquals(15, estoque.consultarQuantidade(queijo));
    }

    @Test
    void naoDeveAdicionarQuantidadeZero() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        assertThrows(
                IllegalArgumentException.class,
                () -> estoque.adicionarIngrediente(queijo, 0)
        );
    }

    @Test
    void deveRemoverIngredienteDoEstoque() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        estoque.adicionarIngrediente(queijo, 10);
        estoque.removerIngrediente(queijo, 4);

        assertEquals(6, estoque.consultarQuantidade(queijo));
    }

    @Test
    void naoDeveRemoverQuantidadeMaiorQueEstoque() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        estoque.adicionarIngrediente(queijo, 2);

        assertThrows(
                IllegalArgumentException.class,
                () -> estoque.removerIngrediente(queijo, 5)
        );
    }

    @Test
    void deveVerificarSePossuiIngrediente() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        estoque.adicionarIngrediente(queijo, 10);

        assertTrue(estoque.possuiIngrediente(queijo, 5));
    }

    @Test
    void deveRetornarFalseQuandoNaoPossuiQuantidadeSuficiente() {
        Estoque estoque = new Estoque();
        Ingrediente queijo = new Ingrediente("Queijo", "unidade");

        estoque.adicionarIngrediente(queijo, 3);

        assertFalse(estoque.possuiIngrediente(queijo, 5));
    }

    @Test
    void repositorioDeveReutilizarMesmoIngrediente() {
        RepositorioIngredientes repositorio = new RepositorioIngredientes();

        Ingrediente queijo1 = repositorio.buscarOuCriar("Queijo", "unidade");
        Ingrediente queijo2 = repositorio.buscarOuCriar("Queijo", "unidade");

        assertSame(queijo1, queijo2);
    }

    @Test
    void repositorioDeveContarTiposDeIngredientes() {
        RepositorioIngredientes repositorio = new RepositorioIngredientes();

        repositorio.buscarOuCriar("Queijo", "unidade");
        repositorio.buscarOuCriar("Bacon", "gramas");

        assertEquals(2, repositorio.quantidadeTiposIngredientes());
    }
}