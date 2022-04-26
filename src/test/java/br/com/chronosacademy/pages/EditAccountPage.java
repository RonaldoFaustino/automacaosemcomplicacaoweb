package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.EditAccountMaps;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {

    EditAccountMaps editAccountMaps = new EditAccountMaps();

    public EditAccountPage(){
        PageFactory.initElements(Driver.getDriver(), editAccountMaps);
    }

    public void setInpFirstName(String firstName){
        Driver.visibilitOf(editAccountMaps.inpFirstName);
        editAccountMaps.inpFirstName.clear();
        editAccountMaps.inpFirstName.sendKeys(firstName);
    }

    public void setInpLastName(String lastName){
        Driver.visibilitOf(editAccountMaps.inpLastName);
        editAccountMaps.inpLastName.clear();
        editAccountMaps.inpLastName.sendKeys(lastName);
    }

    public void clickBtnSave(){
        Driver.aguardarOptions(new Select(editAccountMaps.slcCountry));
        editAccountMaps.btnSave.click();
        editAccountMaps.btnSave.click();
    }


}
