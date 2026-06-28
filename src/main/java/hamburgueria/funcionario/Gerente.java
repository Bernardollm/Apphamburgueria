package hamburgueria.funcionario;

public class Gerente extends Funcionario {

    public Gerente(String nome) {
        super(nome, "Gerente");
    }

    @Override
    public void trabalhar() {
    }

    public boolean podeAcessarRelatorioFinanceiro() {
        return true;
    }
}