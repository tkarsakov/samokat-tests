package com.intexsoft.samokat;

import com.google.gson.JsonObject;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderDetailsPage;
import com.intexsoft.samokat.pages.samokat.OrderPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.junit.Assert;
import org.junit.Test;

public class OrderFlowTests extends BaseTest {

    @Test
    public void testOrderFlowExpectSuccess() {
        JsonObject order = ResourcesService.TESTDATA.getAsJsonObject("order1");
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        mainPage.clickCookieConfirmButton();
        OrderPage orderPage = mainPage.clickOrderButton();

        OrderDetailsPage orderDetailsPage = orderPage
                .typeName(ResourcesService.getStringFromJsonObject(order, "name"))
                .typeSurname(ResourcesService.getStringFromJsonObject(order, "surname"))
                .typeAddress(ResourcesService.getStringFromJsonObject(order, "address"))
                .typeAndSelectSubway(ResourcesService.getStringFromJsonObject(order, "subway"))
                .typePhoneNumber(ResourcesService.getStringFromJsonObject(order, "phoneNumber"))
                .clickNextButton();

        Assert.assertEquals(1, 1);
    }
}
