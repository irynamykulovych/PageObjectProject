package ui;

import framework.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {

  private final MainPage mainPage = new MainPage();

  @Test
  public void checkRegisterUserWithOpenNewPage() {
     String actualMessage = mainPage.clickMyAccount()
            .clickRegisterLink()
            .enterFirstName("Ann")
            .enterLastName("Dann")
            .enterEmail("ann_dann@gmail.com")
            .enterPassword("1111")
            .checkPrivacyPolicy()
            .clickContinueButtonWithOpenNewPage()
             .pageName();


    Assertions.assertThat(actualMessage)
            .as("Actual error message is not as expected")
            .isEqualTo("Welcome");
  }

}
