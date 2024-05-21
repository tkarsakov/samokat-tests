package com.intexsoft.samokat;

import com.intexsoft.samokat.entity.Order;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.junit.Assert;
import org.junit.Test;

public class OrderFormTests extends BaseTest {
    @Test
    public void testOrderFormErrors() {
        MainSamokatPage mainSamokatPage = new MainSamokatPage(driver);
        OrderPage orderPage = mainSamokatPage.clickOrderButton();
        Order order = Order.buildFromJsonString(ResourcesService.TESTDATA.get("incorrectOrder").toString());

        orderPage.typeName(order.getName());
        Assert.assertTrue(orderPage.isNameErrorPresent());
        orderPage.typeSurname(order.getSurname());
        Assert.assertTrue(orderPage.isSurnameErrorPresent());
        orderPage.typeAddress(order.getAddress());
        Assert.assertTrue(orderPage.isAddressErrorPresent());
        orderPage.typePhoneNumber(order.getPhoneNumber());
        Assert.assertTrue(orderPage.isPhoneNumberErrorPresent());
    }
}
