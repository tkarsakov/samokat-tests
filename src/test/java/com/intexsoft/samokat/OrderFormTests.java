package com.intexsoft.samokat;

import com.intexsoft.samokat.entity.Order;
import com.intexsoft.samokat.pages.samokat.MainSamokatPage;
import com.intexsoft.samokat.pages.samokat.OrderPage;
import com.intexsoft.samokat.service.ResourcesService;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class OrderFormTests extends BaseTest {

    @Test
    public void testOrderFormErrors() {
        MainSamokatPage mainSamokatPage = new MainSamokatPage(driver);
        OrderPage orderPage = mainSamokatPage.getSamokatNavBarComponent().clickOrderButton();
        Order order = Order.buildFromJsonString(ResourcesService.TESTDATA.get("incorrectOrder").toString());
        SoftAssertions softAssertions = new SoftAssertions();
        String errorMessage = "Cannot find error message after typing {%s}";

        orderPage.typeName(order.getName());
        softAssertions.assertThat(orderPage.isNameErrorPresent()).withFailMessage(errorMessage, order.getName()).isTrue();
        orderPage.typeSurname(order.getSurname());
        softAssertions.assertThat(orderPage.isSurnameErrorPresent()).withFailMessage(errorMessage, order.getSurname()).isTrue();
        orderPage.typeAddress(order.getAddress());
        softAssertions.assertThat(orderPage.isAddressErrorPresent()).withFailMessage(errorMessage, order.getAddress()).isTrue();
        orderPage.typePhoneNumber(order.getPhoneNumber());
        softAssertions.assertThat(orderPage.isPhoneNumberErrorPresent()).withFailMessage(errorMessage, order.getPhoneNumber()).isTrue();
        softAssertions.assertAll();
    }
}
