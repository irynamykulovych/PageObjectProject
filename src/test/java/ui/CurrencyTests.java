package ui;

import framework.pages.MainPage;
import framework.pages.ProductPage;
//import framework.pages.components.MenuComponent;
import framework.pages.components.ProductComponent;
import framework.pages.helpers.Helpers;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;


public class CurrencyTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkCurrency() {

        String expectedCurrentCurrency = "$";

        String currentCurrency = mainPage.getCurrentCurrency();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(currentCurrency)
                .as("Current currency should $")
                .isEqualTo(expectedCurrentCurrency);


        List<ProductComponent> products = Helpers.getAllProducts();
        ProductPage productPage =  Helpers.getProductByName(products, "iPhone")
                .clickOnProduct();

        String iPhonePrice = productPage.getProductPrice();

        softAssertions.assertThat(iPhonePrice)
                .as("The price is not as expected")
                .isEqualTo("$123.20");

//        List<MenuComponent> currencies = Helpers. getAllCurrency();
//        Helpers.getCurrencyByCurrencyName(currencies, "€ Euro")
//                .clickOnCurrency();

        String iphonePrice = productPage.getProductPrice();
        softAssertions.assertThat(iphonePrice)
                .as("The price is not as expected")
                .isEqualTo("$123.20");

        ProductPage.switchToCurrencyByName("€ Euro");
        iphonePrice = productPage.getProductPrice();
        softAssertions.assertThat(iphonePrice)
                .as("The price is not as expected")
                .isEqualTo("106.04€");

        ProductPage.switchToCurrencyByName("£ Pound Sterling");
        iphonePrice = productPage.getProductPrice();
        softAssertions.assertThat(iphonePrice)
                .as("the price is not as expected")
                .isEqualTo("£95.32");



        softAssertions.assertAll();
    }
}


