package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MenuBar extends BaseElement {

    public MenuBar(final By locator, final String name) {
        super(locator, name);
    }

    public MenuBar(String string, String name) {
        super(string, name);
    }


    public MenuBar(By locator) {
        super(locator);
    }

    protected String getElementType() {
        return getLoc("loc.discount");
    }

    public void dropDown() {
        Actions actions=new Actions(browser.getDriver());
        waitForIsElementPresent();
        info(getLoc("loc.clicking"));
        browser.getDriver().executeScript("arguments[0].style.border='3px solid red'", element);
        actions.moveToElement(element).build().perform();
    }
}
