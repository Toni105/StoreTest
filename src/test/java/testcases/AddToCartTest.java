package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class AddToCartTest extends BaseTest {


    WebDriver driver;
    SearchPage searchPage;
    LoginPage loginPage;
    AccountPage accountPage;
    WishListPage wishListPage;
    HomePage homePage;
    ProductDisplayPage productDisplayPage;

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
    public void verifyAddingProductFrom_ProductDisplayPage() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validProduct"));
        productDisplayPage = searchPage.clickHPLP3065ProductPage();
        Assert.assertTrue(productDisplayPage.addProductInCart());
    }

    @Test(priority = 2)
    public void verifyAddingProductFrom_WishListPage() {
        loginPage = homePage.navigateToLoginPage();
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        loginPage.clickLogoButton();
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validProduct"));
        wishListPage = searchPage.AddProductToWishList_AndGoToWishListPage();
        productDisplayPage = wishListPage.clickAddToCartButton();
        Assert.assertTrue(productDisplayPage.addProductInCart());
    }

    @Test(priority = 3)
    public void verifyRemovingProductFromCart() {
        loginPage = homePage.navigateToLoginPage();
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        loginPage.clickLogoButton();
        Assert.assertTrue(homePage.clickDropDownMenu_ClickDeleteProductButton_AndVerifyText());
    }

    @Test(priority = 4)
    public void verifyAddingProductFrom_SearchResultsPage() {
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validMultipleProduct"));
        Assert.assertTrue(searchPage.addProductInCartAndRetrieveExistenceOfSuccessfullyAddedProductInCartMessage());
    }

    @Test(priority = 5)
    public void verifyAddingProductFrom_ProductDisplayedInCategoryPage() {
        searchPage = homePage.clickMacSubCategoryFromDropDownMenu();
        Assert.assertTrue(searchPage.addProductInCartAndRetrieveExistenceOfSuccessfullyAddedProductInCartMessage());
    }

    @Test(priority = 6)
    public void verifyAddingProductFrom_FeaturedSection_FromHomePage() {
        Assert.assertTrue(homePage.clickButtonAndVerifyAddingProductFromFeaturedSectionToCart());
    }

    @Test(priority = 7)
    public void verifyThatCartIsEmptyAtBegging() {
        Assert.assertEquals(homePage.clickDropDownMenuAndVerifyText(),warningProperties.getProperty("ValueOfEmptyCartText"));
    }

}
