package hamburgueria.estoque;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private final Map<Ingrediente, Double> quantidades = new HashMap<>();

    public void adicionarIngrediente(Ingrediente ingrediente, double quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        quantidades.put(
                ingrediente,
                quantidades.getOrDefault(ingrediente, 0.0) + quantidade
        );
    }

    public void removerIngrediente(Ingrediente ingrediente, double quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        double quantidadeAtual = consultarQuantidade(ingrediente);

        if (quantidadeAtual < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente para " + ingrediente.getNome());
        }

        quantidades.put(ingrediente, quantidadeAtual - quantidade);
    }

    public double consultarQuantidade(Ingrediente ingrediente) {
        return quantidades.getOrDefault(ingrediente, 0.0);
    }

    public boolean possuiIngrediente(Ingrediente ingrediente, double quantidadeNecessaria) {
        return consultarQuantidade(ingrediente) >= quantidadeNecessaria;
    }
}