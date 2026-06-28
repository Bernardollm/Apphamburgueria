package hamburgueria.estoque;

public class Ingrediente {

    private final String nome;
    private final String unidadeMedida;

    public Ingrediente(String nome, String unidadeMedida) {
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }
}