package com.intexsoft.samokat.pages.samokat;

import com.intexsoft.samokat.components.SamokatNavBarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseSamokatPage {

    protected final WebDriver driver;

    private SamokatNavBarComponent samokatNavBarComponent;

    public BaseSamokatPage(WebDriver driver) {
        this.driver = driver;
        this.samokatNavBarComponent = new SamokatNavBarComponent(driver);
        this.init(driver);
    }

    public SamokatNavBarComponent getSamokatNavBarComponent() {
        return samokatNavBarComponent;
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public OrderStatusPage goToOrderByNumber(String number) {
        return samokatNavBarComponent.goToOrderByNumber(number);
    }
}
