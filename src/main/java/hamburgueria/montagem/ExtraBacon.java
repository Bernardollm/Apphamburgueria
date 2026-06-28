package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public class ExtraBacon extends IngredienteExtra {

    public ExtraBacon(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + "Extra bacon; ";
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + 5.00;
    }
}