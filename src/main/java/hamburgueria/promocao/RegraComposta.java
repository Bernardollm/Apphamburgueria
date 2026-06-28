package hamburgueria.promocao;

import hamburgueria.pedido.Pedido;

public class RegraComposta implements RegraPromocao {

    private RegraPromocao primeiraRegra;
    private RegraPromocao segundaRegra;

    public RegraComposta(RegraPromocao primeiraRegra, RegraPromocao segundaRegra) {
        this.primeiraRegra = primeiraRegra;
        this.segundaRegra = segundaRegra;
    }

    @Override
    public boolean interpretar(Pedido pedido) {
        return primeiraRegra.interpretar(pedido) && segundaRegra.interpretar(pedido);
    }
}