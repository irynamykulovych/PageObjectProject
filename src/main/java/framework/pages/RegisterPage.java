package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

  private final By firstNameFieldLocator = By.id("input-firstname");
  private final By lastNameFieldLocator = By.id("input-lastname");
  private final By emailFieldLocator = By.id("input-email");
  private final By passwordFieldLocator = By.id("input-password");
  private final By privacyPolicyCheckBoxLocator = By.xpath("//input[@name='agree']");
  private final By continueButtonLocator = By.xpath("//button[@type='submit']");


  public RegisterPage enterFirstName(String firstName) {
    find(firstNameFieldLocator).sendKeys(firstName);
    return this;
  }
  public RegisterPage enterLastName(String lastName) {
    find(lastNameFieldLocator).sendKeys(lastName);
    return this;
  }
  public RegisterPage enterEmail(String email) {
    find(emailFieldLocator).sendKeys(email);
    return this;
  }
  public RegisterPage enterPassword(String password) {
    find(passwordFieldLocator).sendKeys(password);
    return this;
  }
  public RegisterPage checkPrivacyPolicy() {
    WebElement element = find(privacyPolicyCheckBoxLocator);
      JavascriptExecutor executor = (JavascriptExecutor) driver;
      executor.executeScript("arguments[0].click()", element);
    return this;
  }
  public WelcomePage clickContinueButtonWithOpenNewPage() {
    WebElement element = find(continueButtonLocator);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click()", element);
    return new WelcomePage();
  }

}
