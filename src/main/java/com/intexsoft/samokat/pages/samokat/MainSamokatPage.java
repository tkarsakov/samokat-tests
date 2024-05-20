package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSamokatPage extends BaseSamokatPage {

    private final String FAQ_LIST_XPATH = "(//div[@class=\"accordion__heading\"])[%d]";
    private final String ANSWER_XPATH = "//div[@id=\"accordion__panel-%d\"]/p";
    @FindBy(id = "rcc-confirm-button")
    private WebElement cookieConfirmButton;

    public MainSamokatPage(WebDriver driver) {
        super(driver);
        this.init(driver);
    }

    public MainSamokatPage clickCookieConfirmButton() {
        cookieConfirmButton.click();
        return this;
    }

    public String getAnswerStringByIndex(Integer index) {
        //Add 1 because xpath element lists are not zero indexed
        driver.findElement(By.xpath(String.format(FAQ_LIST_XPATH, index + 1))).click();
        return driver.findElement(By.xpath(String.format(ANSWER_XPATH, index))).getAttribute("innerHTML");
    }

}
