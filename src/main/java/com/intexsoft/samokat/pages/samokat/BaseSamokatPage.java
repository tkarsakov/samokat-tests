package com.intexsoft.samokat.pages.samokat;

import com.intexsoft.samokat.components.SamokatNavBarComponent;
import com.intexsoft.samokat.pages.yandex.YandexPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseSamokatPage {

    protected final WebDriver driver;

    protected SamokatNavBarComponent samokatNavBarComponent;

    public BaseSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    protected MainSamokatPage clickOnSamokatMainPageLink() {
        samokatNavBarComponent.clickMainPageLink();
        return new MainSamokatPage(driver);
    }

    protected YandexPage clickOnYandexLink() {
        samokatNavBarComponent.clickYandexLink();
        return new YandexPage(driver);
    }
}
