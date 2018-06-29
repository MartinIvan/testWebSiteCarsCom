package steps;

import cucumber.api.java.en.When;
import forms.MainForm;
import forms.ResultSearchForm;
import webdriver.Browser;

public class GoToComparePage {
    @When("^I go to compare$")
    public void i_go_to_compare() throws Throwable {

        Browser.getInstance().getDriver().navigate().to("http://www.cars.com/");
        MainForm mainForm=new MainForm();
        mainForm.selectZipCode();
        mainForm.btnSearch.click();
        ResultSearchForm resultSearchForm=new ResultSearchForm();
        resultSearchForm.copmare.click();
        resultSearchForm.goToComparePage.click();


    }
}
