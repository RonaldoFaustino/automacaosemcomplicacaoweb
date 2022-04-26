package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.EditAccountMaps;
import br.com.chronosacademy.pages.EditAccountPage;
import br.com.chronosacademy.pages.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class EditAccountSteps {

    MyAccountPage myAccountPage = new MyAccountPage();
    EditAccountPage editAccountPage = new EditAccountPage();

    Map<String,String> mapDados;

    @Given("que esteja na pagina de alteracao de conta")
    public void queEstejaNaPaginaDeAlteracaoDeConta() {
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
        myAccountPage.clickLinkEdit();

    }
    @When("altero os valores dos seguintes campos")
    public void alteroOsValoresDosSeguintesCampos(Map<String, String > map) {
        mapDados = map;
        editAccountPage.setInpFirstName(map.get("firstname"));
        editAccountPage.setInpLastName(map.get("lastname"));

    }
    @When("for realizado o clique em salvar")
    public void forRealizadoOCliqueEmSalvar() {
        editAccountPage.clickBtnSave();
    }
    @Then("a alteracao foi exibida na pagina myAccount")
    public void aAlteracaoFoiExibidaNaPaginaMyAccount() {
        String nome = mapDados.get("firstname")+" "+mapDados.get("lastname");

        Assertions.assertEquals(nome,myAccountPage.getTextUsuario());
    }
}
