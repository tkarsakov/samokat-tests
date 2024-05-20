package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainSamokatPage extends BaseSamokatPage {

    @FindBy(css = "div.accordion__button")
    private List<WebElement> faqList;



    public MainSamokatPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getFaqList() {
        return faqList;
    }

    public String getAnswerStringByIndex(Integer index) {
        faqList.get(index).click();
        return driver.findElement(By.cssSelector(String.format("#accordion__panel-%d p", index))).getText();
    }
}
