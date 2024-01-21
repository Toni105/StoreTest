package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    WebDriver driver;
    SearchPage searchPage;
    LoginPage loginPage;
    AccountPage accountPage;
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
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), warningProperties.getProperty("noProductFound"), "No product message in search results is not displayed.");
    }

    @Test(priority = 3)
    public void verifySearchWithoutAnyProduct() {
        searchPage = homePage.clickOnSearchButton();
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), warningProperties.getProperty("noProductFound"), "No product message in search results is not displayed.");
    }

    @Test(priority = 4)
    public void verifySearchForProductAfterLogin() {
        loginPage = homePage.navigateToLoginPage();
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validProduct"));
        Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "Valid product HP should be displayed in the search results.");
    }

    @Test(priority = 5)
    public void verifySearchHolderText() {
        Assert.assertTrue(homePage.searchBarHeadingText().contains(placeholderProperties.getProperty("searchHolderText")));
    }

    @Test(priority = 6)
    public void verifySearchBySearchingMultipleProduct() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        Assert.assertEquals(searchPage.retrieveNumberOfMacProduct(), dataProperties.getProperty("actualNumberOfProductsInMacFamily"), "There are invalid number of product on site.");
    }

    @Test(priority = 7)
    public void verifySearchInProductDescription() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        searchPage.searchForProductByDescriptions(dataProperties.getProperty("searchInProductDescriptionByWord"));
        Assert.assertTrue(searchPage.getDisplayStatusOfiMacProduct(), "Search in product description is not working.");
    }

    @Test(priority = 8)
    public void searchForProduct_BySelectingValidCategoryOfProduct() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        searchPage.searchForProductBySelectingTheCategoryOfProduct(dataProperties.getProperty("validMultipleProduct"), 1);
        Assert.assertTrue(searchPage.getDisplayStatusOfiMacProduct(), "Search in product description is not working.");

        //TODO = Test FAILS due to desktop category not showing "iMac" product (iMAC is desktop category).
    }

    @Test(priority = 9)
    public void searchForProduct_BySelectingInvalidCategoryOfProduct() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        searchPage.searchForProductBySelectingTheCategoryOfProduct(dataProperties.getProperty("validMultipleProduct"), 7);
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), warningProperties.getProperty("noProductFound"), "Search in product description is not working.");
    }

    @Test(priority = 10)
    public void searchForProduct_BySelectingValidSubCategoryOfProduct() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        searchPage.searchForProductBySelectingTheCategoryOfProduct(dataProperties.getProperty("validMultipleProduct"), 3);
        Assert.assertTrue(searchPage.getDisplayStatusOfiMacProduct(), "Search in product description is not working.");
    }

    @Test(priority = 11)
    public void searchForProduct_BySelectingInvalidSubCategoryOfProduct() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        searchPage.searchForProductBySelectingTheCategoryOfProduct(dataProperties.getProperty("validMultipleProduct"), 10);
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), warningProperties.getProperty("noProductFound"), "Search in product description is not working.");
    }

    @Test(priority = 12)
    public void changeGridToListView() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        Assert.assertEquals(searchPage.actualLocationOfProduct(),dataProperties.getProperty("expectedCoordinate"));
    }


}