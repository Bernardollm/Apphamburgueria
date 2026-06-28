package hamburgueria.cardapio;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<Produto> produtos;

    public Cardapio() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProduto(String nome) {

        for (Produto produto : produtos) {

            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }

        }

        return null;
    }
}