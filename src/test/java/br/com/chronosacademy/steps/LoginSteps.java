package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {

    LoginPage  loginPage;
    NewAccountPage newAccountPage;

    @Before
    public void iniciaNavegador() {
       new Driver(Browser.CHROME);
    }

    @After
    public void fecharNavegador(){
        Driver.getDriver().quit();
    }

    @Given("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://advantageonlineshopping.com");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        newAccountPage = new NewAccountPage();
        loginPage.aguardarLoader();
    }
    @When("for realizado um clicque fora da modal")
    public void forRealizadoUmClicqueForaDaModal() throws Exception {
        try {
            loginPage.aguardarLoader();
            loginPage.clickDivFdecharModal();
        }catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }

    }

    @Then("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() {
        loginPage.clickDivFdecharModal();
    }

    @When("for realizado um clique icone de fechar modal")
    public void forRealizadoUmCliqueIconeDeFecharModal() {
        loginPage.aguardarLoader();
        loginPage.clickBtnFechar();
    }

    @When("que a modal estaja sendo exibida")
    public void queAModalEstajaSendoExibida() {
        loginPage.visibilityOfBtnFechar();
    }

    @Then("a pagina Create Account deve ser exibida")
    public void aPaginaCreateAccountDeveSerExibida() throws InterruptedException {;
        Thread.sleep(5000);
        loginPage.clickCreateAccount();
        Assert.assertEquals("CREATE ACCOUNT",newAccountPage.getTextNewAccount());
        //loginPage.visibilityOfBtnFechar();
    }

    @When("quando os campos de login forem preenchidos com os valores")
    public void quandoOsCamposDeLoginForemPreenchidosComOsValores(Map<String, String> map) {
       loginPage.aguardarLoader();
       String username = map.get("usuario");
       String password = map.get("senha");
       boolean remember = Boolean.parseBoolean(map.get("remember"));

       loginPage.setInpUserName(username);
       loginPage.setInpPassWord(password);

       if(remember){
           loginPage.clickInpRemember();
       }

    }

    @When("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSingIn();
    }

    @Then("o sistema exibe uma mensagem de erro")
    public void oSistemaExibeUmaMensagemDeErro() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enable = loginPage.isBtnSingIN();
        Assert.assertFalse(enable);
    }

    @Then("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
