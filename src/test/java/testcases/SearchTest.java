package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    WebDriver driver;

    SearchPage searchPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {

        loadPropertiesFiles();
        driver = initializeBrowserAndOpenApplicationURL(properties.getProperty("browserName"), properties.getProperty("resolutionSize"));
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithValidProduct() {

        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validProduct"));

        Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "Valid product HP should be displayed in the search results.");
    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {

        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("invalidProduct"));

        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProperties.getProperty("noProductFound"), "No product message in search results is not displayed.");
    }

    @Test(priority = 3)
    public void verifySearchWithoutAnyProduct() {

        searchPage = homePage.clickOnSearchButton();

        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProperties.getProperty("noProductFound"), "No product message in search results is not displayed.");

    }
}