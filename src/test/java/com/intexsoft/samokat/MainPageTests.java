package com.intexsoft.samokat;

import com.google.gson.JsonElement;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MainPageTests extends BaseTest {

    @Test
    public void testFaqElementExpectSuccess() {
        driver.get(ResourcesService.CONFIG.get("url").toString().replace("\"", ""));
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        mainPage.clickCookieConfirmButton();
        List<JsonElement> faqList = ResourcesService.TESTDATA.getAsJsonArray("faq").asList();

        for (int i = 0; i < faqList.size(); i++) {
            String answerOnPage = mainPage.getAnswerStringByIndex(i);
            String answerFromTestdata = faqList.get(i).toString().replace("\"", "");
            Assert.assertEquals(answerOnPage, answerFromTestdata);
        }
    }
}
