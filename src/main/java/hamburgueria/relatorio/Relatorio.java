package hamburgueria.relatorio;

import hamburgueria.cardapio.Produto;

public interface Relatorio {

    String gerar(Produto produto);
}