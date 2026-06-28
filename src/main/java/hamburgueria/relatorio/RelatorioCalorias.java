package hamburgueria.relatorio;

import hamburgueria.cardapio.Produto;

public class RelatorioCalorias implements Relatorio {

    @Override
    public String gerar(Produto produto) {
        return "Relatório de calorias do produto: " + produto.getNome()
                + " | Calorias estimadas: 650 kcal";
    }
}