package ui;

import framework.pages.MainPage;
import org.assertj.core.api.Assertions;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ui.BaseTest;

import java.util.Arrays;
import java.util.List;

public class BrandTests extends BaseTest {


    private final MainPage mainPage = new MainPage();

    @Test
    public void checkBrandsName() {
        List<WebElement> brandsList = mainPage.clickBrandsLink().getBrands();
        List<String> actualBrandList = Arrays.asList("Apple","Canon","Hewlett-Packard","HTC","Palm","Sony");
        for (WebElement element : brandsList) {

            Assertions.assertThat(actualBrandList)
                    .as("The title is not the same")
                    .contains(element.getText());
        }
    }
}