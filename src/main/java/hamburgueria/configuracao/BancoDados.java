package hamburgueria.configuracao;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {

    private static BancoDados instancia;

    private final List<Object> registros;

    private BancoDados() {
        this.registros = new ArrayList<>();
    }

    public static BancoDados getInstancia() {
        if (instancia == null) {
            instancia = new BancoDados();
        }

        return instancia;
    }

    public void salvar(Object objeto) {
        if (objeto == null) {
            throw new IllegalArgumentException("Objeto não pode ser nulo.");
        }

        registros.add(objeto);
    }

    public int totalRegistros() {
        return registros.size();
    }

    public void limpar() {
        registros.clear();
    }

    public List<Object> listarRegistros() {
        return registros;
    }
}


////Singleton////
