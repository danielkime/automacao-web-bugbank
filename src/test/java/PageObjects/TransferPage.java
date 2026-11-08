package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage {
    private WebDriver driver;

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCampoNumeroConta() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Informe o número da conta']")));
    }

    public WebElement getCampoDigito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.name("digit")));
    }

    public WebElement getCampoValorTransferencia() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Informe o valor da transferência']")));
    }

    public WebElement getCampoDescricao() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Informe uma descrição']")));
    }

    public WebElement getBotaoTransferirAgora() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Transferir agora']")));
    }

    public WebElement getBotaoFecharModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Usa o ID exato encontrado no HTML do modal
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCloseModal")));
    }

    public WebElement getBotaoVoltar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btnBack")));
    }
}