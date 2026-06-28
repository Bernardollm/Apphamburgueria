package hamburgueria.relatorio;

import hamburgueria.cardapio.Produto;

public class RelatorioLucro implements Relatorio {

    @Override
    public String gerar(Produto produto) {
        double custoEstimado = produto.getPreco() * 0.45;
        double lucro = produto.getPreco() - custoEstimado;

        return "Relatório de lucro do produto: " + produto.getNome()
                + " | Lucro estimado: R$ " + lucro;
    }
}