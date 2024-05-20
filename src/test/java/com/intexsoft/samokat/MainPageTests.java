package com.intexsoft.samokat;

import com.google.gson.JsonElement;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.*;
import java.util.List;

public class MainPageTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        URL selenium_url;
        String uri = ResourcesService.CONFIG.get("selenium_url").toString().trim();
        try {
            selenium_url = new URI(uri).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Incorrect URL format.");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String browserName = ResourcesService.CONFIG.get("browserName").toString();
        Capabilities capabilities;
        switch (browserName) {
            case "chrome":
                capabilities = new ChromeOptions();
                break;
            case "firefox":
                capabilities = new FirefoxOptions();
                break;
            default:
                throw new RuntimeException("Browser support not implemented or browserName specified incorrectly");
        }

        driver = new RemoteWebDriver(selenium_url, capabilities);
    }

    @Test
    public void testFaqElementExpectSuccess() {
        driver.get(ResourcesService.CONFIG.get("url").toString());
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        List<JsonElement> faqList = ResourcesService.TESTDATA.getAsJsonArray("faq").asList();

        for (int i = 0; i < faqList.size(); i++) {
            String answerOnPage = mainPage.getAnswerStringByIndex(i);
            String answerFromTestdata = faqList.get(i).toString();
            Assert.assertEquals(answerOnPage, answerFromTestdata);
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
