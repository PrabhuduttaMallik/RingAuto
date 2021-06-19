package com.test.uiautomation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DriverOperations {

    private final static Logger logger = Logger.getLogger(DriverOperations.class.getName());

    public static WebDriver driver;

    /**
     *
     * @param element
     * @return
     * @throws Exception
     */


    public static boolean isElementDisplayed(String element) throws Exception {
        return driver.findElement(By.xpath(element)).isDisplayed();
    }

    public static boolean isElementDisplayedById(String elementByID) throws Exception {
        return driver.findElement(By.id(elementByID)).isDisplayed();
    }

    public static void staleCheck(String element) throws Exception {
        WebElement webElement = getLocator("XPATH",element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webElement)));
    }

    public static void waitForVisibility(String element) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));

    }

    public static void waitForElement() throws Exception {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

    }

    public static void selectBoxOperation(String element, String value) throws Exception {

        System.out.println("Entered---");
        WebElement webElement = driver.findElement(By.xpath(element));
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    /**
     *
     * @param element
     * @throws Exception
     */
    public static void clickOnElement(String element) throws Exception {
        driver.findElement(By.xpath(element)).click();
    }

    public static void jsClickOfElement(String element) throws Exception {

        WebElement webElement = driver.findElement(By.xpath(element));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    /**
     *
     * @param elemnt
     * @return
     * @throws Exception
     */
    public static String getText(String elemnt) throws Exception {
        return driver.findElement(By.xpath(elemnt)).getText();
    }

    public static String getCurrentUrl() throws Exception {
        return driver.getCurrentUrl();
    }

    public static List<WebElement> elementList(String element) throws Exception {

        List<WebElement> elements = driver.findElements(By.xpath(element));
        return elements;
    }

    /**
     *
     * @param element
     * @param testData
     * @throws Exception
     */
    public static void enterText(String element, String testData) throws Exception {
        driver.findElement(By.xpath(element)).sendKeys(testData);
    }

    public static WebElement getLocator(String locatorType, String locatorValue ){

        switch(locatorType.toUpperCase()) {
            case "ID":
                return driver.findElement(By.id(locatorValue ));
            case "CSSSELECTOR":
                return driver.findElement(By.cssSelector(locatorValue));
            case "XPATH":
                return driver.findElement(By.xpath(locatorValue));
            case "NAME":
                return driver.findElement(By.name(locatorValue));
            case "LINKTEXT":
                return driver.findElement(By.linkText(locatorValue));
            case "PARTIALLINKTEXT":
                return driver.findElement(By.partialLinkText(locatorValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(locatorValue));
            case "CLASSNAME":
                return driver.findElement(By.className(locatorValue));
            default:
                logger.info("Incorrect locator or Type" +  locatorType);
        }
        return null;
    }


    /**
     *
     * @return
     * @throws Exception
     */
    public static String getOfferIdFromURL() throws Exception {

        String currentURL = driver.getCurrentUrl();
        URL url = new URL(currentURL);

        String[] val = url.getPath().split("/");

        return val[4];
    }

    /**
     *
     * @param offerID
     * @throws Exception
     */
    public static void popUpHandle(String offerID) throws Exception {

        logger.info("Performing Basic Auth check");

        String userName = TestDataFetcher.getPropertyDetails("username_Auth", System.getProperty("envType"));
        String password = TestDataFetcher.getPropertyDetails("password_Auth", System.getProperty("envType"));
        String redirectionurl = TestDataFetcher.getPropertyDetails("redirectionurl", System.getProperty("envType"));

        ((HasAuthentication)driver).register(UsernameAndPassword.of(userName,password));
        driver.get("https://"+redirectionurl+""+offerID);

        logger.info("Basic Auth Check completed");
    }

    public static void handleWindows(int val) throws Exception {

        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(val));
    }
}
