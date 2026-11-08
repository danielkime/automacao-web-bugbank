package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.RegisterPage;

public class RealizarRegistroContaUm {
    private WebDriver driver;
    private RegisterPage registerPage;

    public RealizarRegistroContaUm(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(driver);
    }

    public void cadastrarContaUm(String email, String nome, String senha) {
        registerPage.getBotaoAcessarCadastro().click();
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        registerPage.getCampoEmail().sendKeys(email);
        registerPage.getCampoNome().sendKeys(nome);
        registerPage.getCampoSenha().sendKeys(senha);
        registerPage.getCampoConfirmarSenha().sendKeys(senha);

        registerPage.getToggleComSaldo().click();
        registerPage.getBotaoCadastrar().click();

        registerPage.getBotaoFecharModal().click();
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}