package Tasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TransferPage;

public class RealizarTransferencia {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private TransferPage transferPage;

    public RealizarTransferencia(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
        this.transferPage = new TransferPage(driver);
    }

    public void fazerLogin(String email, String senha) {
        loginPage.getCampoEmail().clear();
        loginPage.getCampoEmail().sendKeys(email);
        loginPage.getCampoSenha().clear();
        loginPage.getCampoSenha().sendKeys(senha);
        loginPage.getBotaoEntrar().click();
        
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void transferir(String conta, String digito, String valor, String descricao) {
        // Clica no card de transferência na HomePage
        WebElement btnTransf = homePage.getBotaoTransferencia();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnTransf);
        
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }

        // Preenche os campos um a um com segurança
        transferPage.getCampoNumeroConta().sendKeys(conta);
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        
        transferPage.getCampoDigito().sendKeys(digito);
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        
        transferPage.getCampoValorTransferencia().sendKeys(valor);
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        
        transferPage.getCampoDescricao().sendKeys(descricao);
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }

        transferPage.getBotaoTransferirAgora().click();
        
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }

        transferPage.getBotaoFecharModal().click();
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        transferPage.getBotaoVoltar().click();
    }
}