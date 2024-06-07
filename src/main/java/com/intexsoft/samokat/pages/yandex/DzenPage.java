package com.intexsoft.samokat.pages.yandex;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class DzenPage {

    private final WebDriver driver;
    //Title of the dzen page
    @FindBy(xpath = "//title[text()=\"Дзен\"]")
    private WebElement dzenTitle;

    public DzenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Проверяем открыта ли страница Дзен")
    public boolean isPageOpen() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Дзен"));
        return Objects.equals(dzenTitle.getAttribute("innerHTML"), "Дзен");
    }
}
