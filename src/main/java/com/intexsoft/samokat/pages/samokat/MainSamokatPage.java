package com.intexsoft.samokat.pages.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainSamokatPage extends BaseSamokatPage {

    private final String FAQ_LIST_XPATH = "//div[@id=\"accordion__heading-%d\"]";
    private final String ANSWER_XPATH = "//div[@id=\"accordion__panel-%d\"]/p";

    public MainSamokatPage(WebDriver driver) {
        super(driver);
    }

    public String getAnswerStringByIndex(Integer index) {
        driver.findElement(By.xpath(String.format(FAQ_LIST_XPATH, index)));
        return driver.findElement(By.xpath(String.format(ANSWER_XPATH, index))).getAttribute("innerHTML");
    }
}
