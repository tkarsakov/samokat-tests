package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderStatusPage extends BaseSamokatPage {

    @FindBy(css = "div.Track_NotFound__6oaoY")
    private WebElement notFoundDiv;

    @FindBy(css = "div.Track_Content__St6Kn")
    private WebElement trackContainerDiv;

    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOrderFound() {
        return !notFoundDiv.isDisplayed();
    }

    public Boolean isPageOpen() {
        return trackContainerDiv.isDisplayed();
    }
}
