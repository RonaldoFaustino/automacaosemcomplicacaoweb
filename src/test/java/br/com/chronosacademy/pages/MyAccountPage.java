package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.MyAccountMap;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    MyAccountMap myAccountMap = new MyAccountMap();

    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), myAccountMap);
    }

    public void clickLinkUser(){
        myAccountMap.linkUser.click();
    }

    public void clickLinkMyAccount(){
        Driver.visibilitOf(myAccountMap.linkMyAccount);
        myAccountMap.linkMyAccount.click();
    }

    public void clickLinkEdit(){
        Driver.visibilitOf(myAccountMap.linkEdit);
        myAccountMap.linkEdit.click();
    }

    public String getTextUsuario(){
       Driver.visibilitOf(myAccountMap.textUsuario);
       return myAccountMap.textUsuario.getText();
    }

    public void clickBtnDelete(){
        Driver.visibilitOf(myAccountMap.btnDelete);
        myAccountMap.btnDelete.click();
    }

    public void clickBtnYes(){
        Driver.visibilitOf(myAccountMap.btnYes);
        myAccountMap.btnYes.click();
    }

    public String getTextDelete(){
        Driver.visibilitOf(myAccountMap.textDelete);
        return myAccountMap.textDelete.getText();
    }
}
