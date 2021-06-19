package com.test.uiautomation.hooks;

import com.test.uiautomation.utils.DriverOperations;
import com.test.uiautomation.utils.TestDataFetcher;
import com.test.uiautomation.utils.TextFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;

public class SetUpBase extends DriverOperations {

    private static final Logger LOGGER = Logger.getLogger(SetUpBase.class.getName());

    @Before()
    public void setUpBase() throws Exception {
        initialize();
        launchBrowser();
    }
    @After()
    public void endOfTest(Scenario scenario) {
        try{
            if (scenario.isFailed()){
                final byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            }
            driver.quit();
        }catch (Exception e){
            System.out.println("Error is ---"+e);
        }
    }

    public static void initialize() throws Exception {

        String envDetails = TextFileReader.getText("commands.txt");
        String[] values = envDetails.split("[|]", -1);
        LOGGER.info("string length is--------"+values.length);

        LOGGER.info("Env from cmd is---------"+values[0]);
        System.setProperty("envType" ,values[0]);
        LOGGER.info("Testtag from cmd is----"+values[1]);
        System.setProperty("testTags" ,values[1]);
        LOGGER.info("Browser from cmd is----"+values[2]);
        System.setProperty("browser" ,values[2]);
    }

    public WebDriver launchBrowser() {

        String browser = System.getProperty("browser");
        LOGGER.info("The browser is ---"+browser);
        try{
            if(browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                    driver.get(TestDataFetcher.getPropertyDetails("url",System.getProperty("envType")));
            }
            else if(browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

}
