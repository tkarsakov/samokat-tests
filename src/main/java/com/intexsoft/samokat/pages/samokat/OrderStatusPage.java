package com.intexsoft.samokat.pages.samokat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderStatusPage extends BaseSamokatPage {
    //Div containing the "not found" image
    @FindBy(css = "div.Track_NotFound__6oaoY")
    private WebElement notFoundDiv;
    //Div containing the order number
    @FindBy(css = "div.Track_Content__St6Kn")
    private WebElement trackContainerDiv;

    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем присутствует ли заказ (отсутствует картинка, что заказ не найден)")
    public Boolean isOrderFound() {
        return !notFoundDiv.isDisplayed();
    }

    @Step("Проверяем открыта ли страница статуса заказа")
    public Boolean isPageOpen() {
        return trackContainerDiv.isDisplayed();
    }
}
