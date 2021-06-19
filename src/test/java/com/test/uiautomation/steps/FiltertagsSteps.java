package com.test.uiautomation.steps;

import com.test.uiautomation.actions.FilterPageActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class FiltertagsSteps {


    @Given("^I validate \"([^\"]*)\" text on the web page$")
    public void validateHomePage(String validationText) throws Exception {
        FilterPageActions.homePageValidator(validationText);
    }

    @Then("^I click on \"([^\"]*)\" tag on the page$")
    public void clickOnTag(String tagTobeClicked) throws Exception {
            FilterPageActions.clickOnTag(tagTobeClicked);

    }

    @Then("^I wait for \"([^\"]*)\" tag details to appear on the page$")
    public void waitForTagToLoad(String tagToLoad) throws Exception {

        FilterPageActions.waitForVisibility(tagToLoad);
    }

    @Then("^I validate count of \"([^\"]*)\" text on the web page is not less than (\\d+) times$")
    public void countTags(String tagName, int count) throws Exception {

        boolean value = FilterPageActions.listOfTags(tagName, count);
        Assert.assertTrue("Tag count is less than "+count+"",value);
    }

}
