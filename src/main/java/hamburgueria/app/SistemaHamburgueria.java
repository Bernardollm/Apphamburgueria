package hamburgueria.app;

import hamburgueria.atendimento.CentralAtendimento;
import hamburgueria.atendimento.CriarPedido;
import hamburgueria.atendimento.PagarPedido;
import hamburgueria.atendimento.PrepararPedido;
import hamburgueria.cardapio.Cardapio;
import hamburgueria.cardapio.FabricaCardapio;
import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import hamburgueria.configuracao.ConfiguracaoSistema;
import hamburgueria.cozinha.Cozinha;
import hamburgueria.entrega.EntregaDelivery;
import hamburgueria.entrega.Moto;
import hamburgueria.montagem.DiretorMontagem;
import hamburgueria.montagem.ExtraBacon;
import hamburgueria.notificacao.AplicativoCliente;
import hamburgueria.notificacao.PainelCozinha;
import hamburgueria.pagamento.Pagamento;
import hamburgueria.pagamento.PagamentoPix;
import hamburgueria.pedido.Pedido;
import hamburgueria.promocao.Cupom;
import hamburgueria.promocao.Promocao;
import hamburgueria.promocao.PromocaoClienteVip;
import hamburgueria.promocao.PromocaoDia;

public class SistemaHamburgueria {

    private final Cardapio cardapio;
    private final FabricaCardapio fabricaCardapio;
    private final Cozinha cozinha;
    private final CentralAtendimento centralAtendimento;
    private final ConfiguracaoSistema configuracaoSistema;

    public SistemaHamburgueria() {
        this.cardapio = new Cardapio();
        this.fabricaCardapio = new FabricaCardapio();
        this.cozinha = new Cozinha();
        this.centralAtendimento = new CentralAtendimento();
        this.configuracaoSistema = ConfiguracaoSistema.getInstancia();
    }

    public void iniciar() {
    }

    public Pedido realizarPedidoCompleto() {
        Cliente cliente = new Cliente("João", "11999999999");

        Hamburguer hamburguer = new DiretorMontagem()
                .montarXBurger();

        Hamburguer hamburguerComExtra = new ExtraBacon(hamburguer);

        CriarPedido criarPedido = new CriarPedido(cliente, hamburguerComExtra);
        centralAtendimento.executarAcao(criarPedido);

        Pedido pedido = criarPedido.getPedidoCriado();

        pedido.adicionarObservador(new AplicativoCliente());
        pedido.adicionarObservador(new PainelCozinha());

        Promocao promocao = new Cupom("BURGER10");
        promocao
                .ligarCom(new PromocaoDia())
                .ligarCom(new PromocaoClienteVip());

        double desconto = promocao.aplicar(pedido);

        Pagamento pagamento = new PagamentoPix();
        centralAtendimento.executarAcao(new PagarPedido(pedido, pagamento));

        centralAtendimento.executarAcao(new PrepararPedido(cozinha, pedido));

        EntregaDelivery entrega = new EntregaDelivery(new Moto());

        return pedido;
    }

    public void carregarCardapioInicial() {
        cardapio.adicionarProduto(
                (Hamburguer) fabricaCardapio.criarProduto(
                        "hamburguer",
                        "X-Burger",
                        "Hambúrguer tradicional",
                        25.00
                )
        );

        cardapio.adicionarProduto(
                (Hamburguer) fabricaCardapio.criarProduto(
                        "hamburguer",
                        "X-Bacon",
                        "Hambúrguer com bacon",
                        30.00
                )
        );
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    public CentralAtendimento getCentralAtendimento() {
        return centralAtendimento;
    }
}