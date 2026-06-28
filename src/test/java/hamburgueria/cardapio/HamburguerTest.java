package hamburgueria.cardapio;

import hamburgueria.montagem.DiretorMontagem;
import hamburgueria.montagem.ExtraBacon;
import hamburgueria.montagem.ExtraMolhoEspecial;
import hamburgueria.montagem.ExtraOvo;
import hamburgueria.montagem.ExtraQueijo;
import hamburgueria.montagem.MontadorHamburguer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerTest {

    @Test
    void deveCriarHamburguer() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        assertEquals("X-Burger", hamburguer.getNome());
        assertEquals("Tradicional", hamburguer.getDescricao());
        assertEquals(25.00, hamburguer.getPreco());
    }

    @Test
    void deveMontarHamburguerComBuilder() {
        Hamburguer hamburguer = new MontadorHamburguer()
                .definirNome("X-Salada")
                .adicionarPao("Brioche")
                .adicionarCarne("Bovina")
                .adicionarQueijo("Mussarela")
                .montar();

        assertEquals("X-Salada", hamburguer.getNome());
        assertTrue(hamburguer.getPreco() > 0);
    }

    @Test
    void naoDeveMontarHamburguerSemNome() {
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

    @Test
    void extraBaconDeveAumentarPreco() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Hamburguer comBacon = new ExtraBacon(hamburguer);

        assertEquals(30.00, comBacon.getPreco());
    }

    @Test
    void extraQueijoDeveAumentarPreco() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Hamburguer comQueijo = new ExtraQueijo(hamburguer);

        assertEquals(29.00, comQueijo.getPreco());
    }

    @Test
    void extraOvoDeveAumentarPreco() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Hamburguer comOvo = new ExtraOvo(hamburguer);

        assertEquals(28.50, comOvo.getPreco());
    }

    @Test
    void extraMolhoEspecialDeveAumentarPreco() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Hamburguer comMolho = new ExtraMolhoEspecial(hamburguer);

        assertEquals(27.50, comMolho.getPreco());
    }

    @Test
    void extrasPodemSerCombinados() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        Hamburguer completo = new ExtraBacon(new ExtraQueijo(new ExtraOvo(hamburguer)));

        assertEquals(37.50, completo.getPreco());
    }

    @Test
    void extraBaconDeveAlterarDescricao() {
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional; ", 25.00);

        Hamburguer comBacon = new ExtraBacon(hamburguer);

        assertTrue(comBacon.getDescricao().contains("Extra bacon"));
    }
}