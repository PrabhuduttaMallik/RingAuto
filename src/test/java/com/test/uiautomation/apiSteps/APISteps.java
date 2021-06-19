package com.test.uiautomation.apiSteps;

import com.test.uiautomation.apiActions.APIActionDetails;
import cucumber.api.java.en.Given;
import org.junit.Assert;

public class APISteps {

    @Given("^Register an (invalidUser|validUser) with \"([^\"]*)\" email \"([^\"]*)\" password and \"([^\"]*)\" username and validate the response$")
    public void registerUserSteps(String userType, String email, String password, String userName) throws Exception {

            APIActionDetails.registerUser(email, password, userName, userType);

    }

    @Given("^Validate the list of \"([^\"]*)\" present with (\\d+) articlecount$")
    public void getListOfArticle(String article, int count) throws Exception {

            boolean value = APIActionDetails.listAllArticle(article, count);
            Assert.assertTrue("All the ariticles don't have a title", value);
    }

    @Given("^Get the list of articles with the uername \"([^\"]*)\"$")
    public void getListOfArticleByUser(String userName) throws Exception {

        APIActionDetails.getListOfArticleByTheUser(userName);
    }

    @Given("^Get the article details by \"([^\"]*)\" tag$")
    public void getArticleByTag(String tagName) throws Exception {

            APIActionDetails.getArticleByTag(tagName);

    }

    @Given("^I make a get call on all the tags and validate tags$")
    public void getAllTags() throws Exception {

        APIActionDetails.getTagDetails();
    }
}
