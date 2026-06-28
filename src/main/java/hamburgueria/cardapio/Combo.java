package hamburgueria.cardapio;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {

    private String nome;
    private List<ItemCardapio> itens;

    public Combo(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public void removerItem(ItemCardapio item) {
        itens.remove(item);
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return itens.stream()
                .mapToDouble(ItemCardapio::getPreco)
                .sum();
    }
}