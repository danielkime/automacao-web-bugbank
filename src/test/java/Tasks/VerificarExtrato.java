package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;

public class VerificarExtrato {
    private WebDriver driver;
    private HomePage homePage;

    public VerificarExtrato(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
    }

    public void acessarExtrato() {
        homePage.getBotaoExtrato().click();
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void sairDaConta() {
        homePage.getBotaoSair().click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}