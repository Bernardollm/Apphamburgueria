package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public class ExtraMolhoEspecial extends IngredienteExtra {

    public ExtraMolhoEspecial(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + "Extra molho especial; ";
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + 2.50;
    }
}