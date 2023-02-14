package framework.pages.helpers;

import framework.pages.BasePage;
//import framework.pages.components.MenuComponent;
import framework.pages.components.ProductComponent;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Iterables.isEmpty;

public class Helpers {

    @SneakyThrows
    public static List<ProductComponent> getAllProducts() {
        List<ProductComponent> products = new ArrayList<>();
        List<WebElement> containers = BasePage.findAll(By.xpath("//div[@id='content']//div[@class='col']"));
        for (WebElement container : containers) {
            ProductComponent productComponent = new ProductComponent(container);
            products.add(productComponent);
        }
        return products;
    }

    @SneakyThrows
    public static ProductComponent getProductByName(List<ProductComponent> products, String nameToSearch) {

        for (ProductComponent product : products) {
            if (product.getName().equals(nameToSearch)) {
                return product;
            }
        }
        return new ProductComponent();
    }
//    @SneakyThrows
//    public static ProductComponent getProductByPrice(List<ProductComponent> products, String priceToSearch) {
//
//        for (ProductComponent product : products) {
//            if (product.getPrice().equals(priceToSearch)) {
//                return product;
//            }
//        }
//        return new ProductComponent();
    }
//    @SneakyThrows
//    public static List<MenuComponent> getAllCurrency() {
//        List<MenuComponent> currencies = new ArrayList<>();
//        List<WebElement> containers = BasePage.findAll(By.xpath("//li[@class='list-inline-item']"));
//        for (WebElement container : containers) {
//            MenuComponent menuComponent = new MenuComponent(container);
//            currencies.add(menuComponent);
//        }
//        return currencies;
//    }
//    @SneakyThrows
//    public static MenuComponent getCurrencyByCurrencyName(List<MenuComponent> currencies, String nameCurrencyToSearch) {
//
//        for (MenuComponent currency : currencies) {
//            if (currency.getCurrencyName().equals(nameCurrencyToSearch)) {
//                return currency;
//            }
//        }
//        return new MenuComponent();
//    }


