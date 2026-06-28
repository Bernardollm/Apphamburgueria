package hamburgueria.pagamento;

public class PagamentoDinheiro implements Pagamento {

    private double valorRecebido;

    public PagamentoDinheiro(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean pagar(double valor) {
        validarValor(valor);

        if (valorRecebido < valor) {
            throw new IllegalArgumentException("Valor recebido é insuficiente.");
        }

        return true;
    }

    public double calcularTroco(double valor) {
        return valorRecebido - valor;
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
        }
    }
}