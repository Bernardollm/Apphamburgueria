package hamburgueria.entrega;

public interface Transporte {

    String entregar(String endereco);

    double calcularFrete(double distanciaKm);
}