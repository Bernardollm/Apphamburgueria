package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public class ExtraQueijo extends IngredienteExtra {

    public ExtraQueijo(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + "Extra queijo; ";
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + 4.00;
    }
}