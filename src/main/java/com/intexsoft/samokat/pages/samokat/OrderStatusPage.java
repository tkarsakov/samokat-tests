package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderStatusPage extends BaseSamokatPage {

    @FindBy(css = "img[alt=\"Not found\"]")
    private WebElement notFoundImg;

    public OrderStatusPage(WebDriver driver) {
        super(driver);
        this.init(driver);
    }

    public Boolean isOrderFound() {
        return !notFoundImg.isDisplayed();
    }
}
