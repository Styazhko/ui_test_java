package saucedemo;

import core.BaseTest;
import helpers.TestValues;
import org.junit.Assert;
import org.junit.Test;

public class SaucedemoTest extends BaseTest {

    @Test
    public void SuccessfulBuyTest() {
        /*LoginPage loginPage = new LoginPage();
        loginPage.auth_user(TestValues.TEST_LOGIN, TestValues.TEST_PASSWORD);
        ProductsPage productsPage = new ProductsPage();
        productsPage.add_product();
        BasketPage basketPage = new BasketPage();
        basketPage.chekout();
        ChekoutPage chekoutPage = new ChekoutPage();
        chekoutPage.fill_fields(TestValues.TEST_FIRST_NAME, TestValues.TEST_SECOND_NAME, TestValues.TEST_POSTAL_CODE)
                .finish_click();*/
        ChekoutPage chekoutPage = new LoginPage()
                .auth_user(TestValues.TEST_LOGIN, TestValues.TEST_PASSWORD)
                .add_product()
                .chekout()
                .fill_fields(TestValues.TEST_FIRST_NAME, TestValues.TEST_SECOND_NAME, TestValues.TEST_POSTAL_CODE)
                .finish_click();
        Assert.assertEquals(chekoutPage.get_success_message(), TestValues.TEST_SUCCESS_MESSAGE);
        Assert.assertEquals(chekoutPage.get_url(), TestValues.TEST_URL);
    }

    @Test
    public void CheckingErrorMessageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.auth_user(TestValues.TEST_LOGIN_TEST, TestValues.TEST_PASSWORD_TEST);
        /*Assert.assertTrue("Text not found!", loginPage.get_error_message()
                .contains(TestValues.TEST_ERROR_MESSAGE));*/
        Assert.assertEquals(loginPage.get_error_message(), TestValues.TEST_ERROR_MESSAGE);
    }

}