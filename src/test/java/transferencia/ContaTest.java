package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setup(){
        xuxa = new Cliente("Xuxa", "12345678900", "1111111");
        silvioSantos = new Cliente("Silvio Santos","00987654321","2222222");

        contaXuxa = new Conta("0025","2254",2500.00, xuxa);
        contaSilvio = new Conta("0026","2251",3500.00, silvioSantos);
    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000, contaSilvio);

        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());

    }
    @Test
    public void validarTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizarTransferencia(3500.00,contaSilvio);
        assertFalse(resultado);
    }
    @Test
    public void validarProprietario(){
        assertEquals(xuxa, contaXuxa.getProprietario());
    }
    @Test
    public void validarNumeroConta() {
        assertEquals("2254", contaXuxa.getNumeroConta());
    }
    @Test
    public void validarAgencia() {
        assertEquals("0025", contaXuxa.getAgencia());
    }
    @Test
    public void validarNome() {
        assertEquals("nome", Cliente.getNome());
    }
    @Test
    public void validarCPF() {
        assertEquals("cpf", Cliente.getCpf());
    }
    @Test
    public void validarRG() {
        assertEquals("rg", Cliente.getRg());
    }
}