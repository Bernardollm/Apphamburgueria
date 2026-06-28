package hamburgueria.montagem;

import hamburgueria.cardapio.Hamburguer;

public class MontadorHamburguer {

    private String nome;
    private StringBuilder descricao = new StringBuilder();
    private double preco;

    public MontadorHamburguer definirNome(String nome) {
        this.nome = nome;
        return this;
    }

    public MontadorHamburguer adicionarPao(String pao) {
        descricao.append("Pão: ").append(pao).append("; ");
        preco += 3.00;
        return this;
    }

    public MontadorHamburguer adicionarCarne(String carne) {
        descricao.append("Carne: ").append(carne).append("; ");
        preco += 8.00;
        return this;
    }

    public MontadorHamburguer adicionarQueijo(String queijo) {
        descricao.append("Queijo: ").append(queijo).append("; ");
        preco += 4.00;
        return this;
    }

    public MontadorHamburguer adicionarMolho(String molho) {
        descricao.append("Molho: ").append(molho).append("; ");
        preco += 2.00;
        return this;
    }

    public MontadorHamburguer adicionarSalada(String salada) {
        descricao.append("Salada: ").append(salada).append("; ");
        preco += 2.50;
        return this;
    }

    public Hamburguer montar() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalStateException("O hambúrguer precisa ter nome.");
        }

        return new Hamburguer(nome, descricao.toString(), preco);
    }
}