package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.NewAccountMap;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class NewAccountSteps {

    NewAccountPage newAccountPage = new NewAccountPage();
    LoginPage loginPage = new LoginPage();

    String userName;

    @Given("qua a pagina new account esteja sendo exibida")
    public void quaAPaginaNewAccountEstejaSendoExibida() {
        Driver.getDriver().get("https://advantageonlineshopping.com/#/");
        Driver.getDriver().get("https://advantageonlineshopping.com/#/register");
    }
    @When("os campos de cadastro estiverem preenchidos com dados")
    public void osCamposDeCadastroEstiveremPreenchidosComDados(Map<String, String> map) {
        userName = map.get("username");
        newAccountPage.setInputName(userName);
        newAccountPage.setInputEmail(map.get("email"));
        newAccountPage.setInpPassword(map.get("password"));
        newAccountPage.setInpConfirmPassword(map.get("password"));
        newAccountPage.selectCountry(map.get("country"));
        newAccountPage.clickInpIagree();
        newAccountPage.clickBtnRegister();
    }
    @Then("deve ser possivel logar no sistema apos o cadastro")
    public void deveSerPossivelLogarNoSistemaAposOCadastro() {
        Assertions.assertEquals(userName,loginPage.getTextLogado());
    }

}
