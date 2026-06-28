package hamburgueria.pagamento;

public class PagamentoPix implements Pagamento {

    @Override
    public boolean pagar(double valor) {
        validarValor(valor);
        return true;
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
        }
    }
}