package hamburgueria.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

////Abstract Factory////


class ComboTest {

    @Test
    void deveCriarComboVazio() {
        Combo combo = new Combo("Combo Família");

        assertEquals("Combo Família", combo.getNome());
        assertTrue(combo.getItens().isEmpty());
    }

    @Test
    void deveAdicionarItemNoCombo() {
        Combo combo = new Combo("Combo Família");
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        combo.adicionarItem(hamburguer);

        assertEquals(1, combo.getItens().size());
    }

    @Test
    void deveRemoverItemDoCombo() {
        Combo combo = new Combo("Combo Família");
        Hamburguer hamburguer = new Hamburguer("X-Burger", "Tradicional", 25.00);

        combo.adicionarItem(hamburguer);
        combo.removerItem(hamburguer);

        assertTrue(combo.getItens().isEmpty());
    }

    @Test
    void deveCalcularPrecoDoComboComUmItem() {
        Combo combo = new Combo("Combo Simples");
        combo.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25.00));

        assertEquals(25.00, combo.getPreco());
    }

    @Test
    void deveCalcularPrecoDoComboComVariosItens() {
        Combo combo = new Combo("Combo Completo");
        combo.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25.00));
        combo.adicionarItem(new Batata("Batata Média", "Porção média", 12.00));
        combo.adicionarItem(new Bebida("Refrigerante", "Lata", 7.00));

        assertEquals(44.00, combo.getPreco());
    }

    @Test
    void comboVazioDeveTerPrecoZero() {
        Combo combo = new Combo("Combo Vazio");

        assertEquals(0.00, combo.getPreco());
    }

    @Test
    void comboDeveAceitarOutroComboDentro() {
        Combo comboPrincipal = new Combo("Combo Principal");
        Combo comboFilho = new Combo("Combo Filho");

        comboFilho.adicionarItem(new Bebida("Suco", "Natural", 8.00));
        comboPrincipal.adicionarItem(comboFilho);

        assertEquals(8.00, comboPrincipal.getPreco());
    }

    @Test
    void deveCriarComboInfantilPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Combo combo = fabrica.criarComboInfantil();

        assertEquals("Combo Infantil", combo.getNome());
        assertFalse(combo.getItens().isEmpty());
    }

    @Test
    void deveCriarComboFamiliaPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Combo combo = fabrica.criarComboFamilia();

        assertEquals("Combo Família", combo.getNome());
        assertFalse(combo.getItens().isEmpty());
    }

    @Test
    void deveCriarComboPremiumPelaFabrica() {
        FabricaCardapio fabrica = new FabricaCardapio();

        Combo combo = fabrica.criarComboPremium();

        assertEquals("Combo Premium", combo.getNome());
        assertFalse(combo.getItens().isEmpty());
    }
}