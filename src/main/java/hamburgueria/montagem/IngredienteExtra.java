package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public abstract class IngredienteExtra extends Hamburguer {

    protected Hamburguer hamburguer;

    public IngredienteExtra(Hamburguer hamburguer) {
        super(hamburguer.getNome(), hamburguer.getDescricao(), hamburguer.getPreco());
        this.hamburguer = hamburguer;
    }
}