package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;

public class RealizarLogin {
    private WebDriver driver;
    private LoginPage loginPage;

    public RealizarLogin(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void logar(String email, String senha) {
        loginPage.getCampoEmail().clear();
        loginPage.getCampoEmail().sendKeys(email);
        loginPage.getCampoSenha().clear();
        loginPage.getCampoSenha().sendKeys(senha);
        loginPage.getBotaoEntrar().click();
        
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}