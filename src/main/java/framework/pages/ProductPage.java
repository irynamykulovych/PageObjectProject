package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {
    private final By productPriceLocator = By.xpath("//span[@class='price-new']");

    public String getProductPrice() {
        return getDriver().findElement(productPriceLocator).getText();
    }

    private static final By currencyElementsLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li/a");
    private static final By currencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a");
    private static final By currentCurrencyLocator = By.xpath("//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a/strong");

    public static String getCurrentCurrency() {

        return getDriver().findElement(currentCurrencyLocator).getText();
    }

    public static List<WebElement> getAllCurrencies() {

        return BasePage.findAll(currencyElementsLocator);
    }

    public static void switchToCurrencyByName(String name) {
        getDriver().findElement(currencyLocator).click();
        for (WebElement element : getAllCurrencies()) {
            if (element.getText().equals(name)) {
                element.click();
                return;
            }
        }
    }


}
