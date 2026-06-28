package hamburgueria.entrega;

public class Bicicleta implements Transporte {

    @Override
    public String entregar(String endereco) {
        return "Entrega de bicicleta para: " + endereco;
    }

    @Override
    public double calcularFrete(double distanciaKm) {
        return distanciaKm * 1.50;
    }
}