package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    LoginMap loginMap;

    public LoginPage() {
        this.loginMap = loginMap;
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void clickBtnLogin() {
        loginMap.btnlogin.click();
    }

    public void clickBtnFechar(){
        loginMap.btnFechar.click();
    }

    public void clickDivFdecharModal(){
        loginMap.divFecharModal.click();
    }

    public void setInpUserName(String username){
        loginMap.inpUserName.sendKeys(username);
    }

    public void setInpPassWord(String password){
        loginMap.inpPassword.sendKeys(password);
    }

    public void clickInpRemember(){
        loginMap.inpRemember.click();
    }

    public void clickBtnSingIn(){
        loginMap.btnSingIn.click();
    }

    public void clickCreateAccount(){
        loginMap.LinkCreatAccount.click();
    }

    public boolean isBtnSingIN(){
        return loginMap.btnSingIn.isEnabled();
    }
}
