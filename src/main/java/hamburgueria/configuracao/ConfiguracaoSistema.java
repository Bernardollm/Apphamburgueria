package hamburgueria.configuracao;

public class ConfiguracaoSistema {

    private static ConfiguracaoSistema instancia;

    private String nomeSistema;
    private double taxaServico;
    private boolean deliveryAtivo;

    private ConfiguracaoSistema() {
        this.nomeSistema = "Hamburgueria";
        this.taxaServico = 0.10;
        this.deliveryAtivo = true;
    }

    public static ConfiguracaoSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoSistema();
        }

        return instancia;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public boolean isDeliveryAtivo() {
        return deliveryAtivo;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public void setTaxaServico(double taxaServico) {
        if (taxaServico < 0) {
            throw new IllegalArgumentException("Taxa de serviço não pode ser negativa.");
        }

        this.taxaServico = taxaServico;
    }

    public void setDeliveryAtivo(boolean deliveryAtivo) {
        this.deliveryAtivo = deliveryAtivo;
    }
}


////Singleton////
