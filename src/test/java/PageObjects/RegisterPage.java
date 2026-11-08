package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBotaoAcessarCadastro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Registrar']")));
    }

    public WebElement getCampoEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'card__register')]//input[@name='email']")));
    }

    public WebElement getCampoNome() {
        return driver.findElement(By.xpath("//div[contains(@class, 'card__register')]//input[@name='name']"));
    }

    public WebElement getCampoSenha() {
        return driver.findElement(By.xpath("//div[contains(@class, 'card__register')]//input[@name='password']"));
    }

    public WebElement getCampoConfirmarSenha() {
        return driver.findElement(By.xpath("//div[contains(@class, 'card__register')]//input[@name='passwordConfirmation']"));
    }

    public WebElement getToggleComSaldo() {
        return driver.findElement(By.id("toggleAddBalance"));
    }

    public WebElement getBotaoCadastrar() {
        return driver.findElement(By.xpath("//button[text()='Cadastrar']"));
    }

    public WebElement getTextoModalSucesso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));
    }

    public WebElement getBotaoFecharModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCloseModal")));
    }
}