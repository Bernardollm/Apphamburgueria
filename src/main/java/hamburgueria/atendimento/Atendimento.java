package hamburgueria.atendimento;

public class Atendimento {

    private String setor;

    public Atendimento(String setor) {
        this.setor = setor;
    }

    public String enviarMensagem(String mensagem) {
        return setor + " recebeu: " + mensagem;
    }

    public String getSetor() {
        return setor;
    }
}