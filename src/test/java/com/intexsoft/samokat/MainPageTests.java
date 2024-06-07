package com.intexsoft.samokat;

import com.google.gson.JsonElement;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderStatusPage;
import com.intexsoft.samokat.pages.yandex.DzenPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.assertj.core.api.SoftAssertions;
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
        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < faqList.size(); i++) {
            String answerOnPage = mainPage.getAnswerStringByIndex(i);
            String answerFromTestdata = faqList.get(i).toString().replace("\"", "");
            softAssertions.assertThat(answerOnPage)
                    .withFailMessage("Assertion failed because {%s} is not equal to {%s}", answerOnPage, answerFromTestdata)
                    .isEqualTo(answerFromTestdata);
        }
        softAssertions.assertAll();
    }

    //Test for navbar logo link
    @Test
    public void testNavbarMainPageLinkExpectSuccess() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        String expectedUrl = ResourcesService.CONFIG.get("url").toString().replace("\"", "");
        mainPage.getSamokatNavBarComponent().clickOrderButton();
        mainPage.getSamokatNavBarComponent().clickMainPageLink();
        Assert.assertEquals(
                String.format("Assertion failed because current URL {%s} is not {%s}", driver.getCurrentUrl(), expectedUrl),
                expectedUrl, driver.getCurrentUrl()
        );
    }

    //Test for navbar Yandex/Dzen link
    @Test
    public void testYandexNavbarLinkExpectSuccess() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        String originalWindow = driver.getWindowHandle();
        DzenPage dzenPage = mainPage.getSamokatNavBarComponent().clickYandexLink();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertTrue("Assertion failed because Dzen page isn't open or dzenPage.isPageOpen() returned false", dzenPage.isPageOpen());
    }

    @Test
    public void testIncorrectOrderNumber() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        String incorrectOrderNumber = ResourcesService.TESTDATA.get("incorrectOrderNumber").toString().replace("\"", "");

        OrderStatusPage orderStatusPage = mainPage.getSamokatNavBarComponent().goToOrderByNumber(incorrectOrderNumber);
        Assert.assertTrue("Failed to verify if the page is opened through orderStatusPage.isPageOpen() (returned false)", orderStatusPage.isPageOpen());
        Assert.assertFalse("Assertion failed: 'not found' section is not present on the page", orderStatusPage.isOrderFound());
    }
}
