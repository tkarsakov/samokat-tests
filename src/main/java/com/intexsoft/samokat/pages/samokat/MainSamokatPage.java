package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSamokatPage extends BaseSamokatPage {

    @FindBy(css = "")
    private WebElement orderButton;

    public MainSamokatPage(WebDriver driver) {
        super(driver);
    }
}
