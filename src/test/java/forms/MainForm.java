package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.BaseForm;
import webdriver.Browser;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

import java.util.List;

public class MainForm extends BaseForm {

    private static final String formLocator = "//select[@name='stockType']";

    public final Label stockType = new Label("name=stockType", "Stock type");
    public final Label maker = new Label("xPath=//select[@name='stockType']/parent::*/parent::*/following-sibling::div[1]",     "Maker");
    public final Label model = new Label("xPath=//select[@name='stockType']/parent::*/parent::*/following-sibling::div[2]", "Model");
    public final Label maxPrice = new Label("xPath=//select[@name='stockType']/parent::*/parent::*/following-sibling::div[3]", "MaxPrice");
    public final Label mileage = new Label("xPath=//select[@name='stockType']/parent::*/parent::*/following-sibling::div[4]/div", "Mileage");
    public final TextBox zipCode = new TextBox("xPath=//input[@type='tel']", "ZipCode");
    public final Button btnSearch = new Button("xPath=//input[@type='submit']", "Button search");

    private String pathModelList = "//select[@name='stockType']/parent::*/parent::*/following-sibling::div[2]/div/select/option";
    private String pathMarketList = "//select[@name='stockType']/parent::*/parent::*/following-sibling::div[1]/div/select/option";

    private final List<WebElement> stockTypeList = Browser.getInstance().getDriver().findElements(By.xpath("//select[@name='stockType']/option"));
    private final List<WebElement> maxPriceList = Browser.getInstance().getDriver().findElements(By.xpath("//select[@name='stockType']/parent::*/parent::*/following-sibling::div[3]/div/select/child::option"));
    private final List<WebElement> mileageList = Browser.getInstance().getDriver().findElements(By.xpath("//select[@name='stockType']/parent::*/parent::*/following-sibling::div[4]//select/option"));

    public MainForm() {
        super(By.xpath(formLocator), "Main Page");
    }

    public void selectStockType() {

        stockType.click();
        stockTypeList.get(randomInt(stockTypeList.size())).click();

    }

    public void selectMaker() {

        maker.click();
        Browser.getInstance().getDriver().findElements(By.xpath(pathMarketList)).get(randomInt(Browser.getInstance().getDriver().findElements(By.xpath(pathMarketList)).size() - 1)).click();

    }

    public void selectModel() {

        model.click();
        Browser.getInstance().getDriver().findElements(By.xpath(pathModelList)).get(randomInt(Browser.getInstance().getDriver().findElements(By.xpath(pathModelList)).size() - 1)).click();

    }

    public void selectMaxPrice() {

        maxPrice.click();
        maxPriceList.get(randomInt(maxPriceList.size() - 1)).click();

    }

    public void selectMileage() {

        mileage.click();
        mileageList.get(randomInt(mileageList.size())).click();

    }

    public void selectZipCode() {

        zipCode.setText("12545");

    }

    public int randomInt(int maxNumber) {

        return (int) (Math.random() * maxNumber);

    }
    /*Inputs correct data to search for cars*/
    public void inputCorrectData() {

        if (!Browser.getInstance().getDriver().getCurrentUrl().equals("http://www.cars.com")) {
            Browser.getInstance().getDriver().navigate().to("http://www.cars.com");
        }
        MainForm mainForm = new MainForm();
        mainForm.selectStockType();
        mainForm.selectMaker();
        mainForm.selectModel();
        mainForm.selectMaxPrice();
        mainForm.selectMileage();
        mainForm.selectZipCode();
        mainForm.btnSearch.click();
        if (mainForm.checkIsCorrectSearchResult()) {
            mainForm.inputCorrectData();
        }
    }
    /*Checkes is correct search result. If not, goes to Main Page*/
    public boolean checkIsCorrectSearchResult() {

        if (Browser.getInstance().getDriver().findElements(By.xpath("//div[@id='srp-listing-rows-container']/div[@class='shop-srp-listings__listing']")).size() == 0 || Browser.getInstance().getDriver().findElements(By.xpath("//p[@class='no-results-message']")).size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
