package framework.pages.components;

import framework.pages.BasePage;
import framework.pages.ProductPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

//@Getter
//public class MenuComponent extends BasePage {
//
//    private WebElement currencyWeb;
//    private String currencyName;
//
//    public MenuComponent() {
//    }
//
//    public MenuComponent(WebElement container) {
//        this.currencyWeb = container.findElement(By.xpath(".//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/ul/li/a"));
//        this.currencyName = currencyWeb.getText();
//
//    }
//    public ProductPage clickOnCurrency() {
//        clickOnWebElement(this.getCurrencyWeb());
//        return new ProductPage();
//    }
//
//
//}
