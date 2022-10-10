package Homework06.Tests;

import Homework06.Pages.DigitalCollectionPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(Homework06.Utilities.ListenerTest.class)
public class TestDigitalCollection extends BaseTest{

    @BeforeClass
    public void startApp(){
        digitalCollectionPage = new DigitalCollectionPage(driver);
    }

    @Test(groups = {"digitalCollection"})
    public void assertDigitalCollection(){
        Assert.assertTrue(digitalCollectionPage.verifyDigitalCollections().isDisplayed());
    }
    @Test(groups = {"digitalCollection"}, dataProvider = "search list")
    public void searchBox(String text){
        SoftAssert sa = new SoftAssert();
        digitalCollectionPage.searchFor(text);
        digitalCollectionPage.searchBox().sendKeys(Keys.ENTER);
        sa.assertTrue(digitalCollectionPage.results().isDisplayed());
    }

    @DataProvider(name = "search list")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"Abraham Lincoln"},
                {"Benjamin Franklin Papers"},
                {"Earth Day"}
        };
    }
}
