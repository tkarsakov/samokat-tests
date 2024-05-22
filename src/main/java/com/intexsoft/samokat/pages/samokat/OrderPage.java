package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BaseSamokatPage {
    //Formattable string for locating subways in dropdown
    private final String SUBWAY_SELECT_DROPDOWN_FORMATTABLE_XPATH = "//div[text()=\"%s\"]";
    //Name field in order form
    @FindBy(css = "input[placeholder=\"* Имя\"]")
    private WebElement nameInput;
    //Surname field in order form
    @FindBy(css = "input[placeholder=\"* Фамилия\"]")
    private WebElement surnameInput;
    //Address field in order form
    @FindBy(css = "input[placeholder=\"* Адрес: куда привезти заказ\"]")
    private WebElement addressInput;
    //Subway field in order form
    @FindBy(css = "input[placeholder=\"* Станция метро\"]")
    private WebElement subwayInput;
    //Phone number field in order form
    @FindBy(css = "input[placeholder=\"* Телефон: на него позвонит курьер\"]")
    private WebElement phoneNumberInput;
    //Next button to get other fields
    @FindBy(css = "div.Order_NextButton__1_rCA button")
    private WebElement nextButton;
    //Error div below the name input
    @FindBy(xpath = "//div[text()=\"Введите корректное имя\"]")
    private WebElement incorrectNameError;
    //Error div below the surname input
    @FindBy(xpath = "//div[text()=\"Введите корректную фамилию\"]")
    private WebElement incorrectSurnameError;
    //Error div below address field
    @FindBy(xpath = "//div[text()=\"Введите корректный адрес\"]")
    private WebElement incorrectAddressError;
    //Error div below phone number field
    @FindBy(xpath = "//div[text()=\"Введите корректный номер\"]")
    private WebElement incorrectPhoneNumberError;
    //Order header above the form
    @FindBy(css = "div.Order_Header__BZXOb")
    private WebElement orderHeader;

    public OrderPage(WebDriver driver) {
        super(driver);
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

    public Boolean isNameErrorPresent() {
        orderHeader.click();
        return incorrectNameError.isDisplayed();
    }

    public Boolean isSurnameErrorPresent() {
        orderHeader.click();
        return incorrectSurnameError.isDisplayed();
    }

    public Boolean isAddressErrorPresent() {
        orderHeader.click();
        return incorrectAddressError.isDisplayed();
    }

    public Boolean isPhoneNumberErrorPresent() {
        orderHeader.click();
        return incorrectPhoneNumberError.isDisplayed();
    }
}
