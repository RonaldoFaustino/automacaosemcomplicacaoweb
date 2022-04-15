package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void clickBtnLogin() {
        Driver.visibilitOf(loginMap.btnlogin);
        loginMap.btnlogin.click();
    }

    public void clickBtnFechar(){
        Driver.visibilitOf(loginMap.btnFechar);
        loginMap.btnFechar.click();
    }

    public void clickDivFdecharModal(){
        loginMap.divFecharModal.click();
    }

    public void setInpUserName(String username){
        if(username != null){
            loginMap.inpUserName.sendKeys(username);
        }
    }

    public void setInpPassWord(String password){
        if(password != null){
            loginMap.inpPassword.sendKeys(password);
        }
    }

    public void clickInpRemember() {
        loginMap.inpRemember.click();
    }

    public void clickBtnSingIn(){
        loginMap.btnSingIn.click();
    }

    public void clickCreateAccount(){
        Driver.visibilitOf(loginMap.LinkCreatAccount);
        //Driver.isClicabe(loginMap.LinkCreatAccount);
        loginMap.LinkCreatAccount.click();
    }

    public boolean isBtnSingIN(){
        return loginMap.btnSingIn.isEnabled();
    }

    public void visibilityOfBtnFechar(){
        Driver.visibilitOf(loginMap.btnFechar);
    }

    public void invisibilityOfBtnFechar(){
        Driver.invisibilitOf(loginMap.btnFechar);
    }

    public void aguardarLoader(){
        Driver.atributeChange(loginMap.divLoader,"display","none");
    }

    public String getTextLogado(){
        Driver.visibilitOf(loginMap.textLogado);
        return loginMap.textLogado.getText();
    }

    public String getErrorLogin(){
        Driver.visibilitOf(loginMap.textErrorLogin);
        return loginMap.textErrorLogin.getText();
    }
}
