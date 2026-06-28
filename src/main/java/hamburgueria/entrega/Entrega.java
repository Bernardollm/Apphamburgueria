package hamburgueria.entrega;

public abstract class Entrega {

    protected Transporte transporte;

    public Entrega(Transporte transporte) {
        this.transporte = transporte;
    }

    public abstract String realizarEntrega(String endereco);

    public double calcularFrete(double distanciaKm) {
        return transporte.calcularFrete(distanciaKm);
    }
}