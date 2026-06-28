package hamburgueria;

import hamburgueria.app.SistemaHamburgueria;
import hamburgueria.pedido.Pedido;

public class Main {

    public static void main(String[] args) {

        SistemaHamburgueria sistema = new SistemaHamburgueria();

        System.out.println("======================================");
        System.out.println("     SISTEMA DA HAMBURGUERIA");
        System.out.println("======================================");

        sistema.iniciar();

        System.out.println("\nCarregando cardápio...");
        sistema.carregarCardapioInicial();

        System.out.println("\nRealizando pedido...");

        Pedido pedido = sistema.realizarPedidoCompleto();

        System.out.println("\n======================================");
        System.out.println("Resumo do Pedido");
        System.out.println("======================================");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Quantidade de itens: " + pedido.getItens().size());
        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("======================================");
    }
}