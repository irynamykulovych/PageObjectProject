package framework.pages;

import static framework.pages.BasePage.getDriver;


public class WelcomePage extends BasePage {
    public String pageName(){
        return getDriver().getTitle();
    }
}
