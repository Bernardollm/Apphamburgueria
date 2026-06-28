package hamburgueria.estoque;

import java.util.HashMap;
import java.util.Map;

public class RepositorioIngredientes {

    private final Map<String, Ingrediente> ingredientes = new HashMap<>();

    public Ingrediente buscarOuCriar(String nome, String unidadeMedida) {
        String chave = nome.toLowerCase();

        if (!ingredientes.containsKey(chave)) {
            ingredientes.put(chave, new Ingrediente(nome, unidadeMedida));
        }

        return ingredientes.get(chave);
    }

    public int quantidadeTiposIngredientes() {
        return ingredientes.size();
    }
}