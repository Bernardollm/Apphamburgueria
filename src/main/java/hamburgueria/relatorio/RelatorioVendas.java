package hamburgueria.relatorio;

import hamburgueria.cardapio.Produto;

public class RelatorioVendas implements Relatorio {

    @Override
    public String gerar(Produto produto) {
        return "Relatório de vendas do produto: " + produto.getNome()
                + " | Preço: R$ " + produto.getPreco();
    }
}