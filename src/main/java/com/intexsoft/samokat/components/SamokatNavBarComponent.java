package com.intexsoft.samokat.components;

import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderPage;
import com.intexsoft.samokat.pages.samokat.OrderStatusPage;
import com.intexsoft.samokat.pages.yandex.YandexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamokatNavBarComponent {

    private final WebDriver driver;

    @FindBy(css = "a[href=\"/\"]")
    private WebElement samokatMainPageLink;

    @FindBy(css = "a[href=\"//yandex.ru\"]")
    private WebElement yandexLink;

    @FindBy(css = "button.Button_Button__ra12g")
    private WebElement orderButton;

    @FindBy(css = "button.Header_Link__1TAG7")
    private WebElement orderStatusButton;

    public SamokatNavBarComponent(WebDriver driver) {
        this.driver = driver;
        this.init(driver);
    }

    public MainSamokatPage clickMainPageLink() {
        samokatMainPageLink.click();
        return new MainSamokatPage(driver);
    }

    public YandexPage clickYandexLink() {
        yandexLink.click();
        return new YandexPage(driver);
    }

    public OrderPage clickOrderButton() {
        orderButton.click();
        return new OrderPage(driver);
    }

    public SamokatNavBarComponent clickOrderStatusButton() {
        orderStatusButton.click();
        return this;
    }

    public OrderStatusPage goToOrderByNumber(String orderNumber) {
        clickOrderStatusButton();
        driver.findElement(By.cssSelector("input[placeholder=\"Введите номер заказа\"]")).sendKeys(orderNumber);
        driver.findElement(By.ById.xpath("//button[text()=\"Go!\"]")).click();
        return new OrderStatusPage(driver);
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
