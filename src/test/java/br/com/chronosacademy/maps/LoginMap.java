package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {

    @FindBy(id = "menuUser")
    public WebElement btnlogin;

    @FindBy(className = "closeBtn")
    public WebElement btnFechar;

    @FindBy(css = "input[name='username']")
    public WebElement inpUserName;

    @FindBy(className = "PopUp")
    public WebElement divFecharModal;

    @FindBy(css = "input[name='password']")
    public WebElement inpPassword;

    @FindBy(css = "input[name=\"remember_me\"]")
    public WebElement inpRemember;

    @FindBy(id = "sign_in_btnundefined")
    public WebElement btnSingIn;

    @FindBy(xpath = "//a[@class=\"create-new-account ng-scope\"]")
    public WebElement LinkCreatAccount;

    @FindBy(css = ".loader")
    public WebElement divLoader;
}