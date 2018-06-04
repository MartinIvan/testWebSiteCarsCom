package forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.Browser;
import java.util.List;

public class CompareForm extends BaseForm {


    private static final String formLocator = "//section[@class='car-compare__details--listings']";

    private List<WebElement>firstCarCharacteristics=Browser.getInstance().getDriver().findElements(By.xpath("//section[@class='car-compare__details--listings']/div/div[2]/div[1]"));
    private List<WebElement>secondCarCharacteristics=Browser.getInstance().getDriver().findElements(By.xpath("//section[@class='car-compare__details--listings']/div/div[2]/div[2]"));

    public CompareForm() {
        super(By.xpath(formLocator), "Compare Page");
    }

    public List<WebElement> getFirstCarCharacteristics(){
        return firstCarCharacteristics;
    }
    public List<WebElement> getSecondCarCharacteristics(){
        return secondCarCharacteristics;
    }
    public String getTrim(List<WebElement>list){
        return list.get(0).getText();
    }
    public String getMileage(List<WebElement>list){
        return list.get(1).getText();
    }
    public String getEngine(List<WebElement>list){
        return list.get(2).getText();
    }

    public String getTransmission(List<WebElement>list){
        return list.get(3).getText();
    }
    public String getDrivetrain(List<WebElement>list){
        return list.get(4).getText();
    }
    public String getMPG(List<WebElement>list){
        return list.get(5).getText();
    }

    public String getFuel(List<WebElement>list){
        return list.get(6).getText();
    }
    public String getBodystyle(List<WebElement>list){
        return list.get(7).getText();
    }
    public String getPassengerCount(List<WebElement>list){
        return list.get(8).getText();
    }
    public String getExteriorColor(List<WebElement>list){
        return list.get(9).getText();
    }
    public String getInteriorColor(List<WebElement>list){
        return list.get(10).getText();
    }

}
