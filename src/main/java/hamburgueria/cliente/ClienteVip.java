package hamburgueria.cliente;

public class ClienteVip extends Cliente {

    private double percentualDesconto;

    public ClienteVip(String nome, String telefone, double percentualDesconto) {
        super(nome, telefone);
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public boolean isVip() {
        return true;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }
}