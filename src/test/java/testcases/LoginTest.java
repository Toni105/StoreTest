package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
    public void verifyLoginWithValidCredentials() {

        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));

        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your Account Information option is not displayed.");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {

        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(Utilities.fakerGenerateEmail(), dataProperties.getProperty("invalidPassword"));

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataProperties.getProperty("emailPasswordNoMatch");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed.");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {

        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(Utilities.fakerGenerateEmail(), dataProperties.getProperty("validPassword"));

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataProperties.getProperty("emailPasswordNoMatch");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed.");

    }

    @Test(priority = 4)
    public void verifyLoginWithValidEmailAndInvalidPassword() {

        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("invalidPassword"));

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataProperties.getProperty("emailPasswordNoMatch");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed.");

    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {

        loginPage.clickOnLoginButton();

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataProperties.getProperty("emailPasswordNoMatch");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed.");

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

        Assert.assertTrue(loginPage.retrieveEmailAddressHeadingText().contains(dataProperties.getProperty("emailPlaceHolderText")));
    }

    @Test(priority = 9)
    public void verifyPasswordPlaceHolderText() {

        Assert.assertTrue(loginPage.retrievePasswordHeadingText().contains(dataProperties.getProperty("passwordPLaceHolderText")));
    }

    @Test(priority = 10)
    public void verifyLoggingAndLogOut() {

        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        accountPage.clickLogOutButton();
        Assert.assertTrue(accountPage.getLogOutConfirmText(), "Logout functionality not implemented.");

    }


    @Test(priority = 11)
    public void verifyLoggingAndLogOutAndBrowsingBckUsingBACKButton() {
        accountPage = loginPage.enterEmailFieldAndPasswordFieldThanClickLoginButton(dataProperties.getProperty("validEmail"), dataProperties.getProperty("validPassword"));
        accountPage.clickLogOutButtonThanPressBACKButton();
        Assert.assertTrue(accountPage.getLogOutConfirmText(), "After logout, pressing BACK button ");

        //TODO = Test FAILS due to defect
    }

}
