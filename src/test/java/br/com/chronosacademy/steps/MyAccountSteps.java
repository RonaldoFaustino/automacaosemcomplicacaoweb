package br.com.chronosacademy.steps;

import br.com.chronosacademy.pages.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyAccountSteps {

    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("que esteja na pagina MyAccount")
    public void queEstejaNaPaginaMyAccount() {
        myAccountPage.clickLinkUser();
        myAccountPage.clickLinkMyAccount();
    }
    @When("for efetuado a acao de deletar")
    public void forEfetuadoAAcaoDeDeletar() {
        myAccountPage.clickBtnDelete();
        myAccountPage.clickBtnYes();
    }
    @Then("o usuario deve ser deletado")
    public void oUsuarioDeveSerDeletado() {
        Assertions.assertEquals("Account deleted successfully",myAccountPage.getTextDelete());
    }
}
