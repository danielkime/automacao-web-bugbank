package Validacao;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginValidacao {
    private WebDriver driver;

    public LoginValidacao(WebDriver driver) {
        this.driver = driver;
    }

    public void validarMensagemSucessoRegistro(String mensagemEsperada) {
        // Exemplo de validação buscando um elemento de alerta/modal na tela do BugBank
        By elementoMensagem = By.id("modalText");
        String textoObtido = driver.findElement(elementoMensagem).getText();
        
        Assert.assertEquals("A mensagem de sucesso não confere!", mensagemEsperada, textoObtido);
    }
}