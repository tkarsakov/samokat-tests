package com.intexsoft.samokat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.intexsoft.samokat.entity.Order;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderDetailsPage;
import com.intexsoft.samokat.pages.samokat.OrderPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderFlowTests extends BaseTest {

    private final JsonObject orderJson;

    public OrderFlowTests(JsonObject orderJson) {
        this.orderJson = orderJson;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        JsonArray ordersArray = ResourcesService.TESTDATA.getAsJsonArray("orders");
        return new Object[][]{
                {ordersArray.get(0).getAsJsonObject()},
                {ordersArray.get(1).getAsJsonObject()}
        };
    }

    @Test
    public void testOrderFlowExpectSuccess() {
        MainSamokatPage mainPage = new MainSamokatPage(driver);
        mainPage.clickCookieConfirmButton();
        OrderPage orderPage = mainPage.clickOrderButton();
        Order order = Order.buildFromJsonString(orderJson.toString());

        OrderDetailsPage orderDetailsPage = orderPage
                .typeName(order.getName())
                .typeSurname(order.getSurname())
                .typeAddress(order.getAddress())
                .selectSubway(order.getSubway())
                .typePhoneNumber(order.getPhoneNumber())
                .clickNextButton();

        orderDetailsPage
                .typeDate(order.getDate())
                .selectTermByString(order.getTerm())
                .clickScooterColorCheckboxByColor(order.getScooterColor())
                .clickMakeOrderButton()
                .clickConfirmOrderButton();

        Assert.assertTrue(orderDetailsPage.isOrderConfirmed());
    }
}
