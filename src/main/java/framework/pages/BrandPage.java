package framework.pages;

import framework.pages.components.ProductComponent;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrandPage extends BasePage {

  private final By brandLocator = By.xpath("//div[@id='product-manufacturer']//div[@class='col-sm-3']/a");

  public List<WebElement> getBrands() {
    return findAll(brandLocator);
  }

}
