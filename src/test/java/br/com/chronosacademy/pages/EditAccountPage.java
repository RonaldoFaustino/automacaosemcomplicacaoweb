package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.EditAccountMaps;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {

    EditAccountMaps editAccountMaps = new EditAccountMaps();

    public EditAccountPage(){
        PageFactory.initElements(Driver.getDriver(), editAccountMaps);
    }

    public void setInpFirstName(String firstName){
        Driver.visibilitOf(editAccountMaps.inpFirstName);
        editAccountMaps.inpFirstName.sendKeys(firstName);
    }

    public void setInpLastName(String lastName){
        Driver.visibilitOf(editAccountMaps.inpLastName);
        editAccountMaps.inpLastName.sendKeys(lastName);
    }

    public void clickBtnSave(){
        editAccountMaps.btnSave.click();
    }


}
