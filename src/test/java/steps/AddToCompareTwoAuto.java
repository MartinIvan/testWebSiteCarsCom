package steps;

import cucumber.api.java.en.Given;
import forms.CarForm;
import forms.DataForCompare;
import forms.MainForm;
import forms.ResultSearchForm;
import webdriver.Browser;

public class AddToCompareTwoAuto {

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
}
