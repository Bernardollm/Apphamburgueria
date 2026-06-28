package hamburgueria.relatorio;

import hamburgueria.funcionario.Gerente;

public class RelatorioFinanceiroRestrito implements RelatorioFinanceiro {

    private Gerente gerente;

    public RelatorioFinanceiroRestrito(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String gerar() {
        if (gerente == null || !gerente.podeAcessarRelatorioFinanceiro()) {
            throw new SecurityException("Acesso negado ao relatório financeiro.");
        }

        return "Relatório financeiro gerado com sucesso.";
    }
}