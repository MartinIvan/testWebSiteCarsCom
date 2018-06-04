package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.Browser;

import java.util.ArrayList;
import java.util.List;

public class CarForm extends BaseForm {



    private static final String formLocator = "//div[@class='page-section__row details-section__basics']";
    private List<WebElement> characteristics= Browser.getInstance().getDriver().findElements
            (By.xpath("//div[@class='page-section__row details-section__basics']/div/ul/li"));

    public CarForm() {
        super(By.xpath(formLocator), "Car Page");
    }

    public List<WebElement> getCharacteristics(){
        return characteristics;
    }



}
