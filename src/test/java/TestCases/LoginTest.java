package TestCases;

import org.junit.Test;

import Framework.TestBase;
import Tasks.RealizarRegistroContaDois;
import Tasks.RealizarRegistroContaUm;
import Tasks.RealizarTransferencia;
import Tasks.VerificarExtrato;

public class LoginTest extends TestBase {

    @Test
    public void deveExecutarFluxoCompletoTransferenciaEExtratos() {
        RealizarTransferencia transferencia = new RealizarTransferencia(driver);
        VerificarExtrato extrato = new VerificarExtrato(driver);

        // --- 1. CRIAR A CONTA 1 (ISOLADA) ---
        RealizarRegistroContaUm reg1 = new RealizarRegistroContaUm(driver);
        reg1.cadastrarContaUm("conta1.origem@email.com", "Daniel Conta Um", "123456");

        // Vai para a home para garantir o reset visual da SPA
        driver.get("https://bugbank.netlify.app/");
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }

        // --- 2. CRIAR A CONTA 2 (ISOLADA) ---
        RealizarRegistroContaDois reg2 = new RealizarRegistroContaDois(driver);
        String mensagemConta2 = reg2.cadastrarContaDois("conta2.destino@email.com", "Daniel Conta Dois", "123456");
        
        // Trata a string do modal para extrair número e dígito da Conta 2
        String[] partes = mensagemConta2.split(" ");
        String numeroComDigito = partes[2]; // Formato "123-4"
        String contaDestino = numeroComDigito.split("-")[0];
        String digitoDestino = numeroComDigito.split("-")[1];

        // Vai para a home para iniciar os logins
        driver.get("https://bugbank.netlify.app/");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        // --- 3. FAZER LOGIN NA CONTA 1 ---
        transferencia.fazerLogin("conta1.origem@email.com", "123456");

        // --- 4. REALIZAR TRANSFERÊNCIA PARA A CONTA 2 ---
        transferencia.transferir(contaDestino, digitoDestino, "100", "Transferencia Prova");

        // --- 5. EXTRATO DA CONTA 1 ---
        extrato.acessarExtrato();
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        // --- 6. SAIR DA CONTA 1 ---
        extrato.sairDaConta();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        // --- 7. FAZER LOGIN NA CONTA 2 ---
        transferencia.fazerLogin("conta2.destino@email.com", "123456");

        // --- 8. EXTRATO DA CONTA 2 ---
        extrato.acessarExtrato();
        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}