package com.intexsoft.samokat;

import com.google.gson.JsonElement;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.yandex.DzenPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MainPageTests extends BaseTest {

    //Test for FAQ section of the main page
    @Test
    public void testFaqElementExpectSuccess() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        mainPage.clickCookieConfirmButton();
        List<JsonElement> faqList = ResourcesService.TESTDATA.getAsJsonArray("faq").asList();

        for (int i = 0; i < faqList.size(); i++) {
            String answerOnPage = mainPage.getAnswerStringByIndex(i);
            String answerFromTestdata = faqList.get(i).toString().replace("\"", "");
            Assert.assertEquals(answerOnPage, answerFromTestdata);
        }
    }

    //Test for navbar logo link
    @Test
    public void testNavbarMainPageLinkExpectSuccess() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        String expectedUrl = ResourcesService.CONFIG.get("url").toString().replace("\"", "");
        mainPage.clickOrderButton();
        mainPage.clickOnSamokatMainPageLink();
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    //Test for navbar Yandex/Dzen link
    @Test
    public void testYandexNavbarLinkExpectSuccess() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        String originalWindow = driver.getWindowHandle();
        DzenPage dzenPage = mainPage.clickOnYandexLink();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue(dzenPage.isPageOpen());
    }
}
