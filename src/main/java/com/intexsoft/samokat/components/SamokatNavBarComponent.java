package com.intexsoft.samokat.components;

import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderPage;
import com.intexsoft.samokat.pages.samokat.OrderStatusPage;
import com.intexsoft.samokat.pages.yandex.DzenPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SamokatNavBarComponent {

    private final WebDriver driver;
    //Top left main page link
    @FindBy(css = "a[href=\"/\"]")
    private WebElement samokatMainPageLink;
    //Top left dzen link
    @FindBy(css = "a[href=\"//yandex.ru\"]")
    private WebElement yandexLink;
    //Top right order button
    @FindBy(css = "div.Header_Nav__AGCXC button.Button_Button__ra12g")
    private WebElement orderButton;
    //Top right order status button
    @FindBy(css = "button.Header_Link__1TAG7")
    private WebElement orderStatusButton;
    //Top right order number input
    @FindBy(css = "input.Header_Input__xIoUq")
    private WebElement orderNumberInput;
    //Top right Go button
    @FindBy(css = "button.Header_Button__28dPO")
    private WebElement goToOrderButton;

    public SamokatNavBarComponent(WebDriver driver) {
        this.driver = driver;
        this.init(driver);
    }

    @Step("Кликаем на ссылку на главную в навбаре")
    public MainSamokatPage clickMainPageLink() {
        samokatMainPageLink.click();
        return new MainSamokatPage(driver);
    }

    @Step("Кликаем на лого Яндекса")
    public DzenPage clickYandexLink() {
        yandexLink.click();
        return new DzenPage(driver);
    }

    @Step("Кликаем на кнопку 'Заказать'")
    public OrderPage clickOrderButton() {
        orderButton.click();
        return new OrderPage(driver);
    }

    @Step("Кликаем на кнопку 'Статус заказа'")
    public SamokatNavBarComponent clickOrderStatusButton() {
        orderStatusButton.click();
        return this;
    }

    public OrderStatusPage goToOrderByNumber(String orderNumber) {
        clickOrderStatusButton();
        typeOrderNumber(orderNumber);
        return clickGoToOrderButton();
    }

    @Step("Вводим номер заказа в поле ввода")
    public SamokatNavBarComponent typeOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(orderNumberInput));
        orderNumberInput.sendKeys(orderNumber);
        return this;
    }

    @Step("Кликаем кнопку 'Go!'")
    public OrderStatusPage clickGoToOrderButton() {
        goToOrderButton.click();
        return new OrderStatusPage(driver);
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
