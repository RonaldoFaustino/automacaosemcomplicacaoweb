package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountMaps {

    @FindBy(name = "first_nameAccountDetails")
    public WebElement inpFirstName;

    @FindBy(name = "last_nameAccountDetails")
    public WebElement inpLastName;

    @FindBy(css = "#save_tbnundefined")
    public WebElement btnSave;
}
