package hamburgueria.cliente;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComNomeETelefone() {
        Cliente cliente = new Cliente("Maria", "11988887777");

        assertEquals("Maria", cliente.getNome());
        assertEquals("11988887777", cliente.getTelefone());
    }

    @Test
    void clienteComumNaoDeveSerVip() {
        Cliente cliente = new Cliente("João", "11999999999");

        assertFalse(cliente.isVip());
    }

    @Test
    void deveCriarClienteComNomeDiferente() {
        Cliente cliente = new Cliente("Ana", "11911112222");

        assertEquals("Ana", cliente.getNome());
    }

    @Test
    void deveCriarClienteComTelefoneDiferente() {
        Cliente cliente = new Cliente("Carlos", "11933334444");

        assertEquals("11933334444", cliente.getTelefone());
    }

    @Test
    void devePermitirNomeComEspaco() {
        Cliente cliente = new Cliente("Pedro Henrique", "11955556666");

        assertEquals("Pedro Henrique", cliente.getNome());
    }

    @Test
    void devePermitirTelefoneComNoveDigitos() {
        Cliente cliente = new Cliente("Lucas", "999999999");

        assertEquals("999999999", cliente.getTelefone());
    }

    @Test
    void doisClientesPodemTerMesmoNome() {
        Cliente cliente1 = new Cliente("Bruna", "1111");
        Cliente cliente2 = new Cliente("Bruna", "2222");

        assertEquals(cliente1.getNome(), cliente2.getNome());
        assertNotEquals(cliente1.getTelefone(), cliente2.getTelefone());
    }

    @Test
    void deveRetornarFalseParaVipSempreQueClienteForComum() {
        Cliente cliente = new Cliente("Fernanda", "123456789");

        assertFalse(cliente.isVip());
    }
}