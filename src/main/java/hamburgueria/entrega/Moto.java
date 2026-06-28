package hamburgueria.entrega;

public class Moto implements Transporte {

    @Override
    public String entregar(String endereco) {
        return "Entrega de moto para: " + endereco;
    }

    @Override
    public double calcularFrete(double distanciaKm) {
        return distanciaKm * 2.00;
    }
}