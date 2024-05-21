package com.intexsoft.samokat.pages.samokat;

import com.intexsoft.samokat.components.SamokatNavBarComponent;
import com.intexsoft.samokat.pages.yandex.DzenPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseSamokatPage {

    protected final WebDriver driver;

    protected SamokatNavBarComponent samokatNavBarComponent;

    public BaseSamokatPage(WebDriver driver) {
        this.driver = driver;
        this.samokatNavBarComponent = new SamokatNavBarComponent(driver);
        this.init(driver);
    }

    public MainSamokatPage clickOnSamokatMainPageLink() {
        samokatNavBarComponent.clickMainPageLink();
        return new MainSamokatPage(driver);
    }

    public DzenPage clickOnYandexLink() {
        samokatNavBarComponent.clickYandexLink();
        return new DzenPage(driver);
    }

    public OrderPage clickOrderButton() {
        samokatNavBarComponent.clickOrderButton();
        return new OrderPage(driver);
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public OrderStatusPage goToOrderByNumber(String number) {
        return samokatNavBarComponent.goToOrderByNumber(number);
    }
}
