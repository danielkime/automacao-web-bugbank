package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBotaoTransferencia() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Utiliza o ID exato encontrado no HTML da página inicial
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-TRANSFERÊNCIA")));
    }

    public WebElement getBotaoExtrato() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Seguindo o mesmo padrão do BugBank, o extrato usa o ID em maiúsculo
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-EXTRATO")));
    }

    public WebElement getBotaoSair() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btnExit")));
    }
}