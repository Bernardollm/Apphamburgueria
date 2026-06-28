package hamburgueria.atendimento;

import java.util.ArrayList;
import java.util.List;

public class CentralAtendimento {

    private List<AcaoAtendimento> historico = new ArrayList<>();

    public void executarAcao(AcaoAtendimento acao) {
        acao.executar();
        historico.add(acao);
    }

    public int totalAcoesExecutadas() {
        return historico.size();
    }

    public List<AcaoAtendimento> getHistorico() {
        return historico;
    }
}