package framework.pages.components;

import framework.pages.BasePage;
import framework.pages.MainPage;
import framework.pages.ProductPage;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductComponent extends BasePage {

    private WebElement image;
    private WebElement nameWe;
    private String name;
    private String price;
    private String oldPrice;
    private String taxPrice;

    public ProductComponent() {
    }

    public ProductComponent(WebElement container) {
        try {
            this.image = container.findElement(By.xpath(".//form[@data-oc-toggle='ajax']//img[@class='img-fluid']"));
        } catch (NoSuchElementException e) {
            this.image = null;
        }
        this.nameWe = container.findElement(By.xpath(".//form[@data-oc-toggle='ajax']//div[@class='description']/h4/a"));
        this.name = nameWe.getText();
        this.price = container.findElement(By.xpath(".//span[@class='price-new']")).getText();
        try {
            this.oldPrice = container.findElement(By.xpath(".//span[@class='price-old']")).getText();
        } catch (NoSuchElementException exception) {
            this.oldPrice = null;
        }
        try {
            this.taxPrice = container.findElement(By.xpath(".//span[@class='price-tax']")).getText();
        } catch (NoSuchElementException exception) {
            this.taxPrice = null;
        }


    }
    public ProductPage clickOnProduct() {
        clickOnWebElement(this.getNameWe());
        return new ProductPage();
    }


}
