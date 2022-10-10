package Homework06.Tests;

import Homework06.Pages.DigitalCollectionPage;
import Homework06.Pages.SurveyPage;
import Homework06.Utilities.DriverFactory;
import Homework06.Utilities.BrowserType;
import Homework06.Pages.LocHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected LocHomePage locHomePage;
    protected DigitalCollectionPage digitalCollectionPage;
    protected SurveyPage surveyPage;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        switch(browser){
            case "FF":
                this.driver = DriverFactory.getDriver(BrowserType.FIREFOX);
                break;
            case "CHROME":
                this.driver = DriverFactory.getDriver(BrowserType.CHROME);
                break;
            case "EDGE":
                this.driver = DriverFactory.getDriver(BrowserType.EDGE);
                break;
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
