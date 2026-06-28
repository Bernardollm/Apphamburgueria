package hamburgueria.cardapio;

public abstract class Produto implements ItemCardapio, Cloneable {

    private String nome;
    private String descricao;
    private double preco;

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto clonar() {
        try {
            return (Produto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar produto.");
        }
    }

    public String aceitarRelatorio(hamburgueria.relatorio.Relatorio relatorio) {
        return relatorio.gerar(this);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}