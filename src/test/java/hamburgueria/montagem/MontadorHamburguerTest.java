package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

////Builder////


class MontadorHamburguerTest {

    @Test
    void deveMontarHamburguerComNome() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X-Salada")
                .adicionarPao("Brioche")
                .montar();

        assertEquals("X-Salada", hamburguer.getNome());
    }

    @Test
    void deveAdicionarPaoNaDescricao() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarPao("Brioche")
                .montar();

        assertTrue(hamburguer.getDescricao().contains("Brioche"));
    }

    @Test
    void deveAdicionarCarneNaDescricao() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarCarne("Bovina")
                .montar();

        assertTrue(hamburguer.getDescricao().contains("Bovina"));
    }

    @Test
    void deveAdicionarQueijoNaDescricao() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarQueijo("Cheddar")
                .montar();

        assertTrue(hamburguer.getDescricao().contains("Cheddar"));
    }

    @Test
    void deveAdicionarMolhoNaDescricao() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarMolho("Barbecue")
                .montar();

        assertTrue(hamburguer.getDescricao().contains("Barbecue"));
    }

    @Test
    void deveAdicionarSaladaNaDescricao() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarSalada("Alface")
                .montar();

        assertTrue(hamburguer.getDescricao().contains("Alface"));
    }

    @Test
    void deveCalcularPrecoComPaoECarne() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarPao("Brioche")
                .adicionarCarne("Bovina")
                .montar();

        assertEquals(11.00, hamburguer.getPreco());
    }

    @Test
    void deveCalcularPrecoCompleto() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X")
                .adicionarPao("Brioche")
                .adicionarCarne("Bovina")
                .adicionarQueijo("Cheddar")
                .adicionarMolho("Barbecue")
                .adicionarSalada("Alface")
                .montar();

        assertEquals(19.50, hamburguer.getPreco());
    }

    @Test
    void naoDeveMontarSemNome() {
        MontadorHamburguer montador = new MontadorHamburguer()
                .adicionarPao("Brioche");

        assertThrows(IllegalStateException.class, montador::montar);
    }

    @Test
    void diretorDeveMontarXBurger() {
        Hamburguer hamburguer = new DiretorMontagem().montarXBurger();

        assertEquals("X-Burger", hamburguer.getNome());
    }

    @Test
    void diretorDeveMontarXBacon() {
        Hamburguer hamburguer = new DiretorMontagem().montarXBacon();

        assertEquals("X-Bacon", hamburguer.getNome());
    }

    @Test
    void diretorDeveMontarVegetariano() {
        Hamburguer hamburguer = new DiretorMontagem().montarVegetariano();

        assertEquals("Veggie Burger", hamburguer.getNome());
    }
}