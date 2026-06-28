package hamburgueria.notificacao;

public class AplicativoCliente implements Notificacao {

    private String ultimaMensagem;

    @Override
    public void atualizar(String mensagem) {
        this.ultimaMensagem = mensagem;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}