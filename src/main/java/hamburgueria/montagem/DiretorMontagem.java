package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public class DiretorMontagem {

    public Hamburguer montarXBurger() {
        return new MontadorHamburguer()
                .definirNome("X-Burger")
                .adicionarPao("Brioche")
                .adicionarCarne("Bovina")
                .adicionarQueijo("Mussarela")
                .adicionarMolho("Maionese da casa")
                .montar();
    }

    public Hamburguer montarXBacon() {
        return new MontadorHamburguer()
                .definirNome("X-Bacon")
                .adicionarPao("Australiano")
                .adicionarCarne("Bovina")
                .adicionarQueijo("Cheddar")
                .adicionarMolho("Barbecue")
                .montar();
    }

    public Hamburguer montarVegetariano() {
        return new MontadorHamburguer()
                .definirNome("Veggie Burger")
                .adicionarPao("Integral")
                .adicionarCarne("Grão-de-bico")
                .adicionarQueijo("Queijo vegano")
                .adicionarSalada("Alface e tomate")
                .adicionarMolho("Molho verde")
                .montar();
    }
}