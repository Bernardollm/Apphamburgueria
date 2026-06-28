package hamburgueria.entrega;

import hamburgueria.cardapio.Hamburguer;
import hamburgueria.cliente.Cliente;
import hamburgueria.pedido.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntregaTest {

    @Test
    void deveRealizarEntregaComMoto() {
        Entrega entrega = new EntregaDelivery(new Moto());

        String resultado = entrega.realizarEntrega("Rua A");

        assertTrue(resultado.contains("moto"));
    }

    @Test
    void deveRealizarEntregaComCarro() {
        Entrega entrega = new EntregaDelivery(new Carro());

        String resultado = entrega.realizarEntrega("Rua B");

        assertTrue(resultado.contains("carro"));
    }

    @Test
    void deveRealizarEntregaComBicicleta() {
        Entrega entrega = new EntregaDelivery(new Bicicleta());

        String resultado = entrega.realizarEntrega("Rua C");

        assertTrue(resultado.contains("bicicleta"));
    }

    @Test
    void freteMotoDeveSerCalculadoCorretamente() {
        Transporte moto = new Moto();

        assertEquals(20.00, moto.calcularFrete(10));
    }

    @Test
    void freteCarroDeveSerCalculadoCorretamente() {
        Transporte carro = new Carro();

        assertEquals(30.00, carro.calcularFrete(10));
    }

    @Test
    void freteBicicletaDeveSerCalculadoCorretamente() {
        Transporte bicicleta = new Bicicleta();

        assertEquals(15.00, bicicleta.calcularFrete(10));
    }

    @Test
    void entregaDeveUsarMesmoCalculoDoTransporte() {
        Entrega entrega = new EntregaDelivery(new Moto());

        assertEquals(10.00, entrega.calcularFrete(5));
    }

    @Test
    void deveEnviarPedidoParaIfood() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        PlataformaDelivery plataforma = new Ifood();

        String retorno = plataforma.enviarPedido(pedido);

        assertTrue(retorno.contains("iFood"));
    }

    @Test
    void deveEnviarPedidoParaUberEats() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        PlataformaDelivery plataforma = new UberEats();

        String retorno = plataforma.enviarPedido(pedido);

        assertTrue(retorno.contains("Uber Eats"));
    }

    @Test
    void deveEnviarPedidoParaRappi() {
        Pedido pedido = new Pedido(new Cliente("João", "111"));
        pedido.adicionarItem(new Hamburguer("X-Burger", "Tradicional", 25));

        PlataformaDelivery plataforma = new Rappi();

        String retorno = plataforma.enviarPedido(pedido);

        assertTrue(retorno.contains("Rappi"));
    }

    @Test
    void todasPlataformasDevemImplementarInterface() {
        assertInstanceOf(PlataformaDelivery.class, new Ifood());
        assertInstanceOf(PlataformaDelivery.class, new UberEats());
        assertInstanceOf(PlataformaDelivery.class, new Rappi());
    }

    @Test
    void todosTransportesDevemImplementarInterface() {
        assertInstanceOf(Transporte.class, new Moto());
        assertInstanceOf(Transporte.class, new Carro());
        assertInstanceOf(Transporte.class, new Bicicleta());
    }
}