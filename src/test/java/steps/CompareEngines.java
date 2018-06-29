package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import forms.*;
import org.testng.Assert;
import webdriver.Browser;

public class CompareEngines {


    @Then("^I compare engines on compare page and page of car$")
    public void i_check_characteristics_on_compare_and_page_auto() throws Throwable {
        CompareForm compareForm=new CompareForm();

        Assert.assertEquals(compareForm.getEngine(compareForm.getFirstCarCharacteristics()),DataForCompare.getEngine(DataForCompare.getFirstCharacteristics()));
        Assert.assertEquals(compareForm.getEngine(compareForm.getSecondCarCharacteristics()),DataForCompare.getEngine(DataForCompare.getSecondCharacteristics()));

    }
}
