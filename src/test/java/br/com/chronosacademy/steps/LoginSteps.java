package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {

    LoginPage  loginPage;
    NewAccountPage newAccountPage;
    String username;

    @Before
    public void iniciaNavegador(Scenario cenario) {
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criarDiretorio();
    }

    @After
    public void fecharNavegador(Scenario cenario) throws IOException {
        if(cenario.isFailed()){
            Driver.printScreen("Erro steps:"+ cenario.getName());
        }
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
    public void quandoOsCamposDeLoginForemPreenchidosComOsValores(Map<String, String> map) throws IOException {
       loginPage.aguardarLoader();
       username = map.get("usuario");
       String password = map.get("senha");
       boolean remember = Boolean.parseBoolean(map.get("remember"));

       loginPage.setInpUserName(username);
       loginPage.setInpPassWord(password);

       if(remember){
           loginPage.clickInpRemember();
       }

       Driver.printScreen("Preenchimento dos campos de login");
    }

    @When("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSingIn();
    }

    @Then("o sistema exibe uma mensagem de erro")
    public void oSistemaExibeUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect User Name or Password","Incorrect user name or password.", loginPage.getErrorLogin());
    }

    @Then("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enable = loginPage.isBtnSingIN();
        Assert.assertFalse(enable);
    }

    @Then("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws InterruptedException, IOException {
        Assert.assertEquals("Não foi possivel realizar o login",username,loginPage.getTextLogado());
        Driver.printScreen("Logado no Sistema");
    }

    @Given("que esteja loagado no sitema com dados")
    public void queEstejaLoagadoNoSitemaComDados(Map<String, String> map) throws IOException, InterruptedException {
        queAModalEstejaSendoExibida();
        quandoOsCamposDeLoginForemPreenchidosComOsValores(map);
        forRealizadoOCliqueNoBotaoSignIn();
        deveSerPossivelLogarNoSistema();
    }

}
