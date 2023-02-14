package ui;

import framework.pages.BasePage;
import framework.pages.DesktopsPage;
import framework.pages.MainPage;
import framework.pages.components.ProductComponent;
import framework.pages.helpers.Helpers;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;


public class DesktopsTests extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
  public void checkProducts() {
    String expectedDropdownValueCountForShow = "10";
    String expectedDropdownValueForSortBy = "Default";
    int expectedCountProducts = 10;

    DesktopsPage desktopsPage = mainPage
            .clickDesktopsMenu()
            .clickShowAllDesktopsMenu()
            .selectFromShowDropDown("10")
            .selectFromSortByDropDown("Default");

    String currentValueFromShowDropDown = desktopsPage.getCurrentValueFromShowDropDown();
    String currentValueFromSortByDropDown = desktopsPage.getCurrentValueFromSortByDropDown();

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(currentValueFromShowDropDown)
            .as("Dropdown value for Show should be 10")
            .isEqualTo(expectedDropdownValueCountForShow);
    softAssertions.assertThat(currentValueFromSortByDropDown)
            .as("Dropdown value for SortBy should be Default")
            .isEqualTo(expectedDropdownValueForSortBy);

    List<ProductComponent> products = Helpers.getAllProducts();

    softAssertions.assertThat(products.size())
            .as("10 products should be on the page")
            .isEqualTo(expectedCountProducts);


    desktopsPage.selectFromShowDropDown (String.valueOf(25));
    products = Helpers.getAllProducts();

    softAssertions.assertThat(products.size())
            .as("12 products should be on the page")
            .isEqualTo(12);

    String bottomText = desktopsPage.getBottomText();

    softAssertions.assertThat(bottomText)
            .as("Bottom text is not as expected")
            .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");

    desktopsPage.selectFromSortByDropDown("Price (Low > High)");

    softAssertions.assertAll();
  }
}


