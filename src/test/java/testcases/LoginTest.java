package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    AccountPage accountPage;
    ForgotPasswordPage forgotPasswordPage;
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        loadPropertiesFiles();
        driver = initializeBrowserAndOpenApplicationURL(properties.getProperty("browserName"), properties.getProperty("resolutionSize"));
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLogin_WithValidCredentials() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your Account Information option is not displayed.");
    }

    @Test(priority = 2)
    public void verifyLogin_WithInvalidCredentials() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(Utilities.fakerGenerateEmail(), dataProperties.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(warningProperties.getProperty("emailPasswordNoMatch")), "Expected warning message is not displayed.");
    }

    @Test(priority = 3)
    public void verifyLogin_WithInvalidEmail_AndValidPassword() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(Utilities.fakerGenerateEmail(), dataProperties.getProperty("validPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(warningProperties.getProperty("emailPasswordNoMatch")), "Expected warning message is not displayed.");
    }

    @Test(priority = 4)
    public void verifyLogin_WithValidEmail_AndInvalidPassword() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(warningProperties.getProperty("emailPasswordNoMatch")), "Expected warning message is not displayed.");
    }

    @Test(priority = 5)
    public void verifyLogin_WithoutProvidingCredentials() {
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(warningProperties.getProperty("emailPasswordNoMatch")), "Expected warning message is not displayed.");
    }

    @Test(priority = 6)
    public void verifyForgottenPasswordButton() {
        forgotPasswordPage = loginPage.clickOnForgottenPasswordButton();
        Assert.assertTrue(forgotPasswordPage.retrieveForgotPasswordPageHeading().contains(dataProperties.getProperty("expectedForgotPasswordHeading")));
    }

    @Test(priority = 7)
    public void verifyLoggingWithKeyboardKeys() {
        accountPage = loginPage.enterEmailFieldThanPressTABEnterPasswordFieldThanPressENTERToLogin(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your Account Information option is not displayed.");
    }

    @Test(priority = 8)
    public void verifyEmailAddressPlaceHolderText() {
        Assert.assertTrue(loginPage.retrieveEmailAddressHeadingText().contains(placeholderProperties.getProperty("emailPlaceHolderText")));
    }

    @Test(priority = 9)
    public void verifyPasswordPlaceHolderText() {
        Assert.assertTrue(loginPage.retrievePasswordHeadingText().contains(placeholderProperties.getProperty("passwordPLaceHolderText")));
    }

    @Test(priority = 10)
    public void verifyLoggingAndLogOut() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        accountPage.clickLogOut();
        Assert.assertTrue(accountPage.getLogOutConfirmText(), "Logout functionality not implemented.");
    }

    @Test(priority = 11)
    public void verifyLoggingAndLogOut_ThanBrowsingBckUsingBACKButton() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        accountPage.clickLogOutButtonThanPressBACKButton();
        Assert.assertTrue(accountPage.getLogOutConfirmText(), "After logout, pressing BACK button ");

        //TODO = Test FAILS due to defect. Didn't log out after pressing BACK button (after pressing LOG OUT button).
    }

    @Test(priority = 12)
    public void verifyLoggingOnTwoTABS_ThanLogOutOnOneTAB()  {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        Assert.assertTrue(loginPage.openTwoTabs_ThanLogOutOnFirstOne_SwitchOnSecond_ThanRefresh_AndVerifyIsSecondLogOut(),"Second TAB is not LogOut, after LogOut on first one!!");
    }

    @Test (priority = 13)
    public void verifyThatPasswordTextIsHidden() {
        Assert.assertEquals(loginPage.retrieveTypeOfPasswordField(),"password", "Text in password field is not hidden !");
    }

    @Test(priority = 14)
    public void verifyExistenceOfBanners() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.retrieveNewCustomerBanner());
        softAssert.assertTrue(loginPage.retrieveReturningCustomerBanner());
        softAssert.assertAll("Banner/s are not showing!");
    }

    @Test(priority = 15)
    public void verifyExistenceOfTitles() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.retrieveRegisterAccountTitle());
        softAssert.assertTrue(loginPage.retrieveIamReturningCustomerTitle());
        softAssert.assertAll("Title/s are not showing!");
    }

    @Test(priority = 16)
    public void verifyExistenceOfContinueAndLoginButton() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.retrieveContinueToRegisterAccountButton());
        softAssert.assertTrue(loginPage.retrieveLoginButton());
        softAssert.assertAll("Title/s are not showing!");
    }

    @Test(priority = 17)
    public void verifyRegisterAccountDescription() {
        Assert.assertEquals(loginPage.retrieveRegisterAccountDescription(),dataProperties.getProperty("RegDescription"));
    }

    @Test(priority = 18)
    public void verifyLabels_emailAddress_AndPassword() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.retrieveEmailAddressLabel(),labelProperties.getProperty("EmailAddressLoginLabel"));
        softAssert.assertEquals(loginPage.retrievePasswordLabel(),labelProperties.getProperty("PasswordLoginLabel"));
        softAssert.assertAll("Label/s are not showing!");
    }

    @Test(priority = 19)
    public void verifyColumnLabels() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.retrieveLoginColumnLabel(),labelProperties.getProperty("LoginColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveRegisterColumnLabel(),labelProperties.getProperty("RegisterColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveForgottenPasswordColumnLabel(),labelProperties.getProperty("ForgottenPasswordColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveMyAccountColumnLabel(),labelProperties.getProperty("MyAccountColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveAddressBookColumnLabel(),labelProperties.getProperty("AddressBookColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveWishListColumnLabel(),labelProperties.getProperty("WishListColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveOrderHistoryColumnLabel(),labelProperties.getProperty("OrderHistoryColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveDownloadsColumnLabel(),labelProperties.getProperty("DownloadsColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveRecurringPaymentsColumnLabel(),labelProperties.getProperty("RecurringPaymentsColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveRewardPointsColumnLabel(),labelProperties.getProperty("RewardPointsColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveReturnsColumnLabel(),labelProperties.getProperty("ReturnsColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveTransactionColumnLabel(),labelProperties.getProperty("TransactionColumnLabel"));
        softAssert.assertEquals(loginPage.retrieveNewsletterColumnLabel(),labelProperties.getProperty("NewsletterColumnLabel"));
        softAssert.assertAll("Label/s are not showing!");
    }

}
