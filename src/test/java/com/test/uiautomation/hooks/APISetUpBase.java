package com.test.uiautomation.hooks;

import com.test.uiautomation.utils.TextFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class APISetUpBase {

    @Before(order = 1)
    public void setUp() throws Exception {

        System.out.println("------[ Initializing setUp for API Test ]------");
        initializeSetUP();
    }

    public void initializeSetUP() throws Exception {

        String environmentDetails = TextFileReader.getText("apiCommands.txt");
        String[] tokens = environmentDetails.split("[|]", -1);
        System.out.println("Length is ---"+tokens.length);

        System.out.println("Environment details ---"+tokens[0]);
        System.getProperty("envType", tokens[0]);

        System.out.println("TestTags details ---"+tokens[1]);
        System.getProperty("testTags", tokens[1]);
    }

    @After()
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
            //delete user
            //delete comment
        }
    }
}
