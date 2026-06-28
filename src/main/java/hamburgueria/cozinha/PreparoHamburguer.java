package hamburgueria.cozinha;

import hamburgueria.cardapio.Hamburguer;

public abstract class PreparoHamburguer {

    public final void preparar(Hamburguer hamburguer) {
        separarIngredientes(hamburguer);
        prepararCarne();
        aquecerPao();
        montarHamburguer(hamburguer);
        embalar();
    }

    protected void separarIngredientes(Hamburguer hamburguer) {
    }

    protected abstract void prepararCarne();

    protected void aquecerPao() {
    }

    protected void montarHamburguer(Hamburguer hamburguer) {
    }

    protected void embalar() {
    }
}