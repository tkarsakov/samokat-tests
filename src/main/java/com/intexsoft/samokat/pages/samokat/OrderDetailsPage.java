package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BaseSamokatPage {

    @FindBy(css = "input[placeholder=\"* Когда привезти самокат\"]")
    private WebElement dateInput;

    @FindBy(css = "div.Order_FilledDate__1pb8n")
    private WebElement termSelectDiv;

    @FindBy(xpath = "//div[@class=\"Order_Buttons__1xGrp\"]/button[text()=\"Заказать\"]")
    private WebElement orderButton;

    @FindBy(xpath = "//div[@class=\"Order_Buttons__1xGrp\"]/button[text()=\"Да\"]")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[text()=\"Заказ оформлен\"]")
    private WebElement orderConfirmedDiv;

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public OrderDetailsPage clickScooterColorCheckboxByColor(String scooterColor) {
        driver.findElement(By.id(scooterColor)).click();
        return this;
    }

    public Boolean isOrderConfirmed() {
        return orderConfirmedDiv.isDisplayed();
    }

    public Boolean isConfirmButtonDisplayed() {
        return confirmOrderButton.isDisplayed();
    }

    public OrderDetailsPage typeDate(String date) {
        dateInput.sendKeys(date);
        return this;
    }

    public OrderDetailsPage selectTermByString(String term) {
        termSelectDiv.click();
        driver.findElement(By.xpath(String.format("//div[text()=\"%s\"]", term))).click();
        return this;
    }
}
