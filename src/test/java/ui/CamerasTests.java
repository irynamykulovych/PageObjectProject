package ui;

import framework.pages.MainPage;
import framework.pages.ProductPage;
import framework.pages.components.ProductComponent;
import framework.pages.helpers.Helpers;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;


public class CamerasTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void checkProductsPrice() {
        ProductPage productPage = mainPage.clickCamerasMenu();
        List<ProductComponent> product = Helpers.getAllProducts();
        SoftAssertions softAssertions = new SoftAssertions();

        int camerasCountValue = product.size();
        softAssertions.assertThat(camerasCountValue)
                .as("2 products should be on the page")
                .isEqualTo(2);

        List<ProductComponent> products = Helpers.getAllProducts();
        Helpers.getProductByName(products, "Canon EOS 5D");

        ProductComponent canon = Helpers
                .getProductByName(products, "Canon EOS 5D");
        softAssertions.assertThat(canon.getOldPrice())
                .as("Product old price is not equals expected")
                .isEqualTo("$122.00");
        softAssertions.assertThat(canon.getPrice())
                .as("Product new price is not equals expected")
                .isEqualTo("$98.00");

        ProductComponent nikon = Helpers
                .getProductByName(products, "Nikon D300");

        softAssertions.assertThat(nikon.getTaxPrice())
                .as("Product tax price is not equals expected")
                .isEqualTo("Ex Tax: $80.00");

        softAssertions.assertAll();
    }
}



