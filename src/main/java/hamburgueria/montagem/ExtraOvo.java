package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public class ExtraOvo extends IngredienteExtra {

    public ExtraOvo(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + "Extra ovo; ";
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + 3.50;
    }
}