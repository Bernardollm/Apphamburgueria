package hamburgueria.pagamento;

public class PagamentoCartao implements Pagamento {

    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean pagar(double valor) {
        validarValor(valor);
        validarCartao();
        return true;
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
        }
    }

    private void validarCartao() {
        if (numeroCartao == null || numeroCartao.length() < 4) {
            throw new IllegalArgumentException("Número do cartão inválido.");
        }
    }
}