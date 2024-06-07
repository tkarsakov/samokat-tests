package com.intexsoft.samokat.pages.samokat;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BaseSamokatPage {
    //Formattable string for locating term options
    private final String SELECTED_TERM_FORMATTABLE_XPATH = "//div[text()=\"%s\"]";
    //Order form date input
    @FindBy(css = "input[placeholder=\"* Когда привезти самокат\"]")
    private WebElement dateInput;
    //Order form term select div
    @FindBy(css = "div.Dropdown-root")
    private WebElement termSelectDiv;
    //Order button below the form
    @FindBy(xpath = "//div[@class=\"Order_Buttons__1xGrp\"]/button[text()=\"Заказать\"]")
    private WebElement orderButton;
    //Confirm order button from modal window
    @FindBy(xpath = "//div[@class=\"Order_Buttons__1xGrp\"]/button[text()=\"Да\"]")
    private WebElement confirmOrderButton;
    //Div containing order confirmation
    @FindBy(xpath = "//div[text()=\"Заказ оформлен\"]")
    private WebElement orderConfirmedDiv;
    //Highlited day in datepicker
    @FindBy(css = "div.react-datepicker__day--selected")
    private WebElement selectedDate;

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликаем чекбокс по цвету {scooterColor}")
    public OrderDetailsPage clickScooterColorCheckboxByColor(String scooterColor) {
        driver.findElement(By.id(scooterColor)).click();
        return this;
    }

    @Step("Подтверждаем, что див с подтверждением заказа присутствует")
    public Boolean isOrderConfirmed() {
        return orderConfirmedDiv.isDisplayed();
    }

    @Step("Подтверждаем, что кнопка подтверждения заказа присутствует")
    public Boolean isConfirmButtonDisplayed() {
        return confirmOrderButton.isDisplayed();
    }

    @Step("Вводим дату {date} и кликаем на подсвеченный день в календарике")
    public OrderDetailsPage typeDate(String date) {
        dateInput.sendKeys(date);
        selectedDate.click();
        return this;
    }

    @Step("Выбираем срок аренды {term} в дропдаун меню")
    public OrderDetailsPage selectTermByString(String term) {
        termSelectDiv.click();
        driver.findElement(By.xpath(String.format(SELECTED_TERM_FORMATTABLE_XPATH, term))).click();
        return this;
    }

    @Step("Кликаем кнопку 'Сделать заказ'")
    public OrderDetailsPage clickMakeOrderButton() {
        getScreenshot();
        orderButton.click();
        return this;
    }

    @Step("Кликаем кнопку 'Подтвердить заказ'")
    public OrderDetailsPage clickConfirmOrderButton() {
        confirmOrderButton.click();
        return this;
    }
}
