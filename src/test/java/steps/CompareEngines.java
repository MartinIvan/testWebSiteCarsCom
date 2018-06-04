package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import forms.*;
import org.testng.Assert;
import webdriver.Browser;

public class CompareEngines {

    DataForCompare dataForCompare=new DataForCompare();
    @Given("^I search two auto and add to compare$")
    public void i_search_two_auto_and_add_to_compare() throws Throwable {
        Browser.getInstance().getDriver().navigate().to("http://www.cars.com/");
        Browser.getInstance().getDriver().manage().window().maximize();
        MainForm mainForm=new MainForm();
        mainForm.inputCorrectData();

        ResultSearchForm resultSearchForm=new ResultSearchForm();
        resultSearchForm.addToCompareAndGoToPageAuto();

        CarForm firstCarForm=new CarForm();
        DataForCompare.setFirstcharacteristics(firstCarForm.getCharacteristics());
        mainForm.inputCorrectData();

        ResultSearchForm secondResultSearchForm =new ResultSearchForm();
        secondResultSearchForm.addToCompareAndGoToPageAuto();
        CarForm secondCarForm=new CarForm();
        DataForCompare.setSecondCharacteristics(secondCarForm.getCharacteristics());
    }

    @When("^I go to compare$")
    public void i_go_to_compare() throws Throwable {

        Browser.getInstance().getDriver().navigate().to("http://www.cars.com/");
        MainForm mainForm=new MainForm();
        mainForm.btnSearch.click();
        ResultSearchForm resultSearchForm=new ResultSearchForm();
        resultSearchForm.copmare.click();
        resultSearchForm.goToComparePage.click();


    }

    @Then("^I compare engines in compare page and page auto$")
    public void i_check_characteristics_on_compare_and_page_auto() throws Throwable {
        CompareForm compareForm=new CompareForm();

        Assert.assertEquals(compareForm.getEngine(compareForm.getFirstCarCharacteristics()),DataForCompare.getEngine(DataForCompare.getFirstCharacteristics()));
        Assert.assertEquals(compareForm.getEngine(compareForm.getSecondCarCharacteristics()),DataForCompare.getEngine(DataForCompare.getSecondCharacteristics()));

    }
}
