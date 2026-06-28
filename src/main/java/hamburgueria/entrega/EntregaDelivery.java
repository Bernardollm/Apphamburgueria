package hamburgueria.entrega;

public class EntregaDelivery extends Entrega {

    public EntregaDelivery(Transporte transporte) {
        super(transporte);
    }

    @Override
    public String realizarEntrega(String endereco) {
        return transporte.entregar(endereco);
    }
}