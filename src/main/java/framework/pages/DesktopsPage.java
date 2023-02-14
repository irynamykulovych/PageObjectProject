package framework.pages;

import framework.pages.components.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DesktopsPage extends BasePage {
    private final By showDropDownLocator = By.id("input-limit");
    private final By sortByDropDownLocator = By.id("input-sort");
    private final By bottomTextLocator = By.xpath("//div[@class='col-sm-6 text-end']");


    public DesktopsPage selectFromShowDropDown(String value) {
        Select select = new Select(find(showDropDownLocator));
        select.selectByVisibleText(value);
        return this;
    }

    public String getCurrentValueFromShowDropDown() {
        Select select = new Select(find(showDropDownLocator));
        return  select.getFirstSelectedOption().getText();
    }

    public DesktopsPage selectFromSortByDropDown(String value) {
        Select select = new Select(find(sortByDropDownLocator));
        select.selectByVisibleText(value);
        return this;
    }

    public String getCurrentValueFromSortByDropDown() {
        Select select = new Select(find(sortByDropDownLocator));
        return  select.getFirstSelectedOption().getText();
    }

    public String getBottomText() {
        return  find(bottomTextLocator).getText();
    }


}
