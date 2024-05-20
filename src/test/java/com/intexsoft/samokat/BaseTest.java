package com.intexsoft.samokat;

import com.intexsoft.samokat.service.ResourcesService;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        URL selenium_url;
        String uri = ResourcesService.CONFIG.get("selenium_url").toString().replace("\"", "");
        try {
            selenium_url = new URI(uri).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Incorrect URL format.");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String browserName = ResourcesService.CONFIG.get("browserName").toString().replace("\"", "");
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
        driver.get(ResourcesService.CONFIG.get("url").toString().replace("\"", ""));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
