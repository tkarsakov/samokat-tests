package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSamokatPage extends BaseSamokatPage {
    //Formattable string for accessing FAQ block on the main page
    private final String FAQ_LIST_FORMATTABLE_XPATH = "(//div[@class=\"accordion__heading\"])[%d]";
    //And one for answers
    private final String ANSWER_FORMATTABLE_XPATH = "//div[@id=\"accordion__panel-%d\"]/p";

    //Button to confirm cookies
    @FindBy(id = "rcc-confirm-button")
    private WebElement cookieConfirmButton;

    public MainSamokatPage(WebDriver driver) {
        super(driver);
    }

    public MainSamokatPage clickCookieConfirmButton() {
        cookieConfirmButton.click();
        return this;
    }

    public String getAnswerStringByIndex(Integer index) {
        //Add 1 because xpath element lists are not zero indexed
        driver.findElement(By.xpath(String.format(FAQ_LIST_FORMATTABLE_XPATH, index + 1))).click();
        return driver.findElement(By.xpath(String.format(ANSWER_FORMATTABLE_XPATH, index))).getAttribute("innerHTML");
    }

}
