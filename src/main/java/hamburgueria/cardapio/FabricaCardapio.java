package hamburgueria.cardapio;

public class FabricaCardapio {

    public Produto criarProduto(String tipo, String nome, String descricao, double preco) {

        if (tipo.equalsIgnoreCase("hamburguer")) {
            return new Hamburguer(nome, descricao, preco);
        }

        if (tipo.equalsIgnoreCase("bebida")) {
            return new Bebida(nome, descricao, preco);
        }

        if (tipo.equalsIgnoreCase("batata")) {
            return new Batata(nome, descricao, preco);
        }

        if (tipo.equalsIgnoreCase("sobremesa")) {
            return new Sobremesa(nome, descricao, preco);
        }

        throw new IllegalArgumentException("Tipo de produto inválido.");
    }

    public Combo criarComboInfantil() {
        Combo combo = new Combo("Combo Infantil");
        combo.adicionarItem(new Hamburguer("Mini Burger", "Hambúrguer pequeno", 15.00));
        combo.adicionarItem(new Batata("Batata Pequena", "Porção pequena", 8.00));
        combo.adicionarItem(new Bebida("Suco", "Suco natural", 6.00));
        return combo;
    }

    public Combo criarComboFamilia() {
        Combo combo = new Combo("Combo Família");
        combo.adicionarItem(new Hamburguer("X-Burger", "Hambúrguer tradicional", 25.00));
        combo.adicionarItem(new Hamburguer("X-Bacon", "Hambúrguer com bacon", 30.00));
        combo.adicionarItem(new Batata("Batata Grande", "Porção grande", 18.00));
        combo.adicionarItem(new Bebida("Refrigerante 2L", "Refrigerante grande", 14.00));
        return combo;
    }

    public Combo criarComboPremium() {
        Combo combo = new Combo("Combo Premium");
        combo.adicionarItem(new Hamburguer("Burger Premium", "Hambúrguer especial", 38.00));
        combo.adicionarItem(new Batata("Batata Cheddar Bacon", "Batata especial", 22.00));
        combo.adicionarItem(new Bebida("Milkshake", "Milkshake artesanal", 18.00));
        combo.adicionarItem(new Sobremesa("Brownie", "Brownie com calda", 16.00));
        return combo;
    }
}