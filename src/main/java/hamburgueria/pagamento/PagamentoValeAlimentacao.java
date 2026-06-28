package hamburgueria.pagamento;

public class PagamentoValeAlimentacao implements Pagamento {

    private double saldo;

    public PagamentoValeAlimentacao(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean pagar(double valor) {
        validarValor(valor);

        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente no vale alimentação.");
        }

        saldo -= valor;

        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
        }
    }
}