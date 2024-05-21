package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BaseSamokatPage {

    private final String SUBWAY_SELECT_DROPDOWN_FORMATTABLE_XPATH = "//div[text()=\"%s\"]";
    @FindBy(css = "input[placeholder=\"* Имя\"]")
    private WebElement nameInput;
    @FindBy(css = "input[placeholder=\"* Фамилия\"]")
    private WebElement surnameInput;
    @FindBy(css = "input[placeholder=\"* Адрес: куда привезти заказ\"]")
    private WebElement addressInput;
    @FindBy(css = "input[placeholder=\"* Станция метро\"]")
    private WebElement subwayInput;
    @FindBy(css = "input[placeholder=\"* Телефон: на него позвонит курьер\"]")
    private WebElement phoneNumberInput;
    @FindBy(css = "div.Order_NextButton__1_rCA button")
    private WebElement nextButton;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.init(driver);
    }

    public OrderPage typeName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public OrderPage typeSurname(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }

    public OrderPage typeAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public OrderPage selectSubway(String subway) {
        subwayInput.click();
        driver.findElement(By.xpath(String.format(SUBWAY_SELECT_DROPDOWN_FORMATTABLE_XPATH, subway))).click();
        return this;
    }

    public OrderPage typePhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public OrderDetailsPage clickNextButton() {
        nextButton.click();
        return new OrderDetailsPage(driver);
    }
}
