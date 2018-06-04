package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.BaseForm;
import webdriver.Browser;
import webdriver.elements.Button;
import webdriver.elements.Label;

import java.util.List;

public class ResultSearchForm extends BaseForm {

    private static final String formLocator = "//div[@class='listing-row__details']";
    private int randomNumber;
    public final Button copmare = new Button("xPath=//button[@class='cui-button compare-tray__toggle-btn']", " Compare'");
    public final Button goToComparePage = new Button("xPath=//button[@class='cui-button compare-tray__btn-compare-state']", "To page of compare");
    private List<WebElement>listAddToCompare=Browser.getInstance().getDriver().findElements(By.xpath("//div[@class='save-compare']/div[2]/input[1]"));
    private List<WebElement> listSearchResult = Browser.getInstance().getDriver().findElements(By.xpath("//div[@id='srp-listing-rows-container']/div[@class='shop-srp-listings__listing']"));

    public ResultSearchForm() {
        super(By.xpath(formLocator), "Result page");
    }


    public void addToCompareAndGoToPageAuto() throws InterruptedException {

        randomNumber = randomInt();
        JavascriptExecutor executor = (JavascriptExecutor)Browser.getInstance().getDriver();
        executor.executeScript("arguments[0].click();", listAddToCompare.get(randomNumber));
        Thread.sleep(5000);
        listSearchResult.get(randomNumber).click();

    }

    public int randomInt() {
        return (int) (Math.random() * listSearchResult.size());
    }

}
