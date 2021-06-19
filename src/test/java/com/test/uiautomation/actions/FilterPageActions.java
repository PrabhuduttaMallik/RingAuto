package com.test.uiautomation.actions;

import com.test.uiautomation.pages.FilterTagPage;
import com.test.uiautomation.utils.DriverOperations;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class FilterPageActions {

    public static Logger LOGGER = Logger.getLogger(FilterPageActions.class.getName());

    public static void homePageValidator(String homePageText) throws Exception {

        if (homePageText.equalsIgnoreCase("Global Feed")) {
            DriverOperations.waitForVisibility(FilterTagPage.globalFeedText);
            String globalFeedText = DriverOperations.getText(FilterTagPage.globalFeedText).trim();
            System.out.println("ds =" + globalFeedText);
            Assert.assertEquals("Global Feed text not present", homePageText, globalFeedText);
        }

    }

    public static void waitForVisibility(String tagIs) throws Exception {

            DriverOperations.waitForVisibility(FilterTagPage.tagResult(tagIs));
    }

    public static void clickOnTag(String tagToCLick) throws Exception {

            DriverOperations.clickOnElement(FilterTagPage.tagResult(tagToCLick));
    }

    public static boolean listOfTags(String tagName, int val) throws Exception {

        int count=0;
        DriverOperations.waitForVisibility(FilterTagPage.tagInResult);
                List<WebElement> list = DriverOperations.elementList(FilterTagPage.tagInResult);
                for (WebElement element : list) {
                    String value = element.getText();
                    System.out.println(value);
                    if (value.equalsIgnoreCase(tagName))
                    {
                        count++;
                    }
                }
                if (count < val)
                {
                    return false;
            }else {
                    return true;
                }
    }

}
