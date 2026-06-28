package hamburgueria.pedido;

import hamburgueria.cardapio.ItemCardapio;
import hamburgueria.cliente.Cliente;
import hamburgueria.notificacao.Notificacao;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itens;
    private EstadoPedido estado;
    private List<Notificacao> observadores;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.estado = new PedidoRecebido();
        this.observadores = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(new ItemPedido(item, 1));
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        itens.add(new ItemPedido(item, quantidade));
    }

    public void adicionarObservador(Notificacao notificacao) {
        observadores.add(notificacao);
    }

    public void removerObservador(Notificacao notificacao) {
        observadores.remove(notificacao);
    }

    private void notificarObservadores() {
        String mensagem = "Pedido de " + cliente.getNome() + " agora está: " + getStatus();

        for (Notificacao notificacao : observadores) {
            notificacao.atualizar(mensagem);
        }
    }

    public double calcularTotal() {
        return itens.stream()
                .mapToDouble(ItemPedido::calcularSubtotal)
                .sum();
    }

    public void avancarStatus() {
        estado.proximo(this);
        notificarObservadores();
    }

    public void cancelar() {
        estado.cancelar(this);
        notificarObservadores();
    }

    public PedidoSnapshot salvarEstado() {
        return new PedidoSnapshot(getStatus(), new ArrayList<>(itens));
    }

    public void restaurarEstado(PedidoSnapshot snapshot) {
        this.itens = new ArrayList<>(snapshot.getItens());

        switch (snapshot.getStatus()) {
            case RECEBIDO -> this.estado = new PedidoRecebido();
            case EM_PREPARO -> this.estado = new PedidoEmPreparo();
            case PRONTO -> this.estado = new PedidoPronto();
            case SAIU_PARA_ENTREGA -> this.estado = new PedidoSaiuParaEntrega();
            case ENTREGUE -> this.estado = new PedidoEntregue();
            case CANCELADO -> this.estado = new PedidoCancelado();
        }

        notificarObservadores();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return estado.getStatus();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}