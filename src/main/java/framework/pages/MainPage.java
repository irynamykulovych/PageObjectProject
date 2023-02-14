package framework.pages;

import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

  private final By footerBrandsLocator = By.xpath(
      "//*[contains(@href,'manufacturer')]");
  private final By headerMyAccountLocator = By.xpath("//i[@class='fas fa-user']/following-sibling::span");
  private final By myAccountRegisterLocator = By.xpath(
          "//*[contains(@href,'register')]");
  private final By desktopsMenuLocator = By.xpath(
          "//ul[@class='nav navbar-nav']/li[1]/a");
  private final By showAllDesktopsMenuLocator = By.xpath(
          "//a[text()='Show All Desktops']");
  private final By currencyLocator = By.xpath(
          "//nav[@id='top']//div[@class='nav float-start']//div[@class='dropdown']/a/strong");
  private final By camerasMenuLocator = By.xpath("//div[@id='narbar-menu']/ul/li[7]/a");


  public BrandPage clickBrandsLink() {
    WebElement element = find(footerBrandsLocator);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click()", element);
    return new BrandPage();
  }
  public MainPage clickMyAccount() {
    find(headerMyAccountLocator).click();
    return this;
  }
  public RegisterPage clickRegisterLink() {
    find(myAccountRegisterLocator).click();
    return new RegisterPage();
  }
  public MainPage clickDesktopsMenu() {
    find(desktopsMenuLocator).click();
    return this;
  }
  public DesktopsPage clickShowAllDesktopsMenu() {
    find(showAllDesktopsMenuLocator).click();
    return new DesktopsPage();
  }
  public String getCurrentCurrency() {

    return getDriver()
            .findElement(currencyLocator)
            .getText();
  }
  public ProductPage clickCamerasMenu() {
    find(camerasMenuLocator).click();
    return new ProductPage();
  }


}

