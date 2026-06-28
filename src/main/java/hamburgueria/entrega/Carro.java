package hamburgueria.entrega;

public class Carro implements Transporte {

    @Override
    public String entregar(String endereco) {
        return "Entrega de carro para: " + endereco;
    }

    @Override
    public double calcularFrete(double distanciaKm) {
        return distanciaKm * 3.00;
    }
}