package com.intexsoft.samokat.pages.samokat;

import com.intexsoft.samokat.components.SamokatNavBarComponent;
import com.intexsoft.samokat.pages.yandex.YandexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseSamokatPage {

    protected final WebDriver driver;

    protected SamokatNavBarComponent samokatNavBarComponent;

    public BaseSamokatPage(WebDriver driver) {
        this.driver = driver;
        this.samokatNavBarComponent = new SamokatNavBarComponent(driver);
    }

    public MainSamokatPage clickOnSamokatMainPageLink() {
        samokatNavBarComponent.clickMainPageLink();
        return new MainSamokatPage(driver);
    }

    public YandexPage clickOnYandexLink() {
        samokatNavBarComponent.clickYandexLink();
        return new YandexPage(driver);
    }

    public OrderPage clickOrderButton() {
        samokatNavBarComponent.clickOrderButton();
        return new OrderPage(driver);
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
