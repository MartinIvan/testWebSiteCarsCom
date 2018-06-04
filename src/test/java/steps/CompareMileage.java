package steps;


import cucumber.api.java.en.Then;
import forms.CompareForm;
import forms.DataForCompare;
import org.testng.Assert;
import webdriver.Browser;

public class CompareMileage {

    @Then("^I compare mileages in compare page and page auto$")
    public void iCompareMileagesInCompareAndPageAuto() throws Throwable {
        CompareForm compareForm=new CompareForm();
        Assert.assertEquals(compareForm.getMileage(compareForm.getFirstCarCharacteristics()),DataForCompare.getMileage(DataForCompare.getFirstCharacteristics()));
        Assert.assertEquals(compareForm.getMileage(compareForm.getSecondCarCharacteristics()),DataForCompare.getMileage(DataForCompare.getSecondCharacteristics()));
        Browser.getInstance().getDriver().quit();
    }
}
