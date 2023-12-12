package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilities.Utilities;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        loadPropertiesFiles();

        driver = initializeBrowserAndOpenApplicationURL(properties.getProperty("browserName"), properties.getProperty("resolutionSize"));
        HomePage homePage = new HomePage(driver);
        registerPage = homePage.navigateToRegisterPage();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFiles() {

        accountSuccessPage = registerPage.fillAllDataInRegistration(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));

        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");

    }

    @Test(priority = 2)
    public void verifyRegisteringAccountByProvidingAllFields() {

        accountSuccessPage = registerPage.fillAllDataInRegistrationIncludingNewsletterOption(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));

        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");

    }

    @Test(priority = 3)
    public void verifyRegisteringAccountWithExistingEmailAddress() {

        accountSuccessPage = registerPage.fillAllDataInRegistrationIncludingNewsletterOption(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), dataProperties.getProperty("validEmail"), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));

        Assert.assertEquals(registerPage.retrieveDuplicateEmailAddressWarning(), dataProperties.getProperty("expectedAlreadyRegisteredEmailWarning"), "Warning message is not display!");

    }

    @Test(priority = 4)
    public void verifyRegisteringAccountWithoutFillingAnyDetails() {

        registerPage.clickContinueButton();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(registerPage.retrievePrivacyPolicyWarning(), dataProperties.getProperty("expectedPrivacyPolicyWarning"), "Privacy Policy Warning is not display!");
        softAssert.assertEquals(registerPage.retrieveFirstNameWarning(), dataProperties.getProperty("expectedFirstNameWarning"), "First Name Warning message is not display!");
        softAssert.assertEquals(registerPage.retrieveLastNameWarning(), dataProperties.getProperty("expectedLastNameWarning"), "Last Name Warning message is not display!");
        softAssert.assertEquals(registerPage.retrieveEmailWarning(), dataProperties.getProperty("expectedEmailWarning"), "Warning E-mail message is not display!");
        softAssert.assertEquals(registerPage.retrieveTelephoneWarning(), dataProperties.getProperty("expectedTelephoneWarning"), "Warning Telephone message is not display!");
        softAssert.assertEquals(registerPage.retrievePasswordWarning(), dataProperties.getProperty("expectedPasswordWarning"), "Warning Password message is not display!");

        softAssert.assertAll("There are some Warning text that are not showing.");
    }

    @Test(priority = 5)
    public void verifyRegisteringByEnteringDifferentPasswordInPasswordAndPasswordConfirmFields() {

        accountSuccessPage = registerPage.fillAllDataInRegistrationWithDifferentPasswordAndConfirmPassword(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"), dataProperties.getProperty("invalidPassword"));

        Assert.assertEquals(registerPage.PasswordAndConfirmPasswordWarning(), dataProperties.getProperty("expectedPasswordNotMatchHeading"), "Warning message is not display!");
    }

    @Test(priority = 6)
    public void retrieveRegisteringHeadingTextForAllText() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(registerPage.retrieveFirstNameHeadingText().contains(dataProperties.getProperty("headingTextForFirstName")));
        softAssert.assertTrue(registerPage.retrieveLastNameHeadingText().contains(dataProperties.getProperty("headingTextForLastName")));
        softAssert.assertTrue(registerPage.retrieveEmailHeadingText().contains(dataProperties.getProperty("headingTextForEmail")));
        softAssert.assertTrue(registerPage.retrieveTelephoneHeadingText().contains(dataProperties.getProperty("headingTextForTelephone")));
        softAssert.assertTrue(registerPage.retrievePasswordHeadingText().contains(dataProperties.getProperty("headingTextForPassword")));
        softAssert.assertTrue(registerPage.retrievePasswordConfirmHeadingText().contains(dataProperties.getProperty("headingTextForPasswordConfirm")));

        softAssert.assertAll("There are some Heading text that are not showing.");
    }

    @Test(priority = 7)
    public void verifyRegisteringByProvidingAnInvalidEmailAddress() {

        accountSuccessPage = registerPage.fillAllDataInRegistrationIncludingNewsletterOption(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), dataProperties.getProperty("incompleteEmail"), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));

        Assert.assertEquals(registerPage.retrieveEmailWarning(), dataProperties.getProperty("expectedEmailWarning"), "Warning E-mail message is not display!");
    }

    @Test(priority = 8)
    public void verifyRegisteringAccountByProvidingAllFieldsWithMinimumPermittedCondition() {

        accountSuccessPage = registerPage.fillAllDataInRegistration(dataProperties.getProperty("firstNameMinimumPermittedRequirement"), dataProperties.getProperty("lastNameMinimumPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("telephoneMinimumPermittedRequirement"), dataProperties.getProperty("passwordMinimumPermittedRequirement"));

        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");
    }

    @Test(priority = 9)
    public void verifyRegisteringAccountByProvidingAllFieldsWithMaximumPermittedCondition() {

        accountSuccessPage = registerPage.fillAllDataInRegistration(dataProperties.getProperty("firstNameMaximumPermittedRequirement"), dataProperties.getProperty("lastNameMaximumPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("telephoneMaximumPermittedRequirement"), dataProperties.getProperty("passwordMaximumPermittedRequirement"));

        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");
    }

    @Test(priority = 10)
    public void verifyRegisteringAccountByProvidingAllFieldsWithExceedingPermittedConditions() {

        SoftAssert softAssert = new SoftAssert();
        accountSuccessPage = registerPage.fillAllDataInRegistration(dataProperties.getProperty("firstNameExceedingPermittedRequirement"), dataProperties.getProperty("lastNameExceedingPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("telephoneExceedingPermittedRequirement"), dataProperties.getProperty("passwordExceedingPermittedRequirement"));

        softAssert.assertEquals(registerPage.retrieveFirstNameWarning(), dataProperties.getProperty("expectedFirstNameWarning"), "First Name exceeding the permitted conditions!");
        softAssert.assertEquals(registerPage.retrieveLastNameWarning(), dataProperties.getProperty("expectedLastNameWarning"), "Last Name exceeding the permitted conditions!");
        softAssert.assertEquals(registerPage.retrieveTelephoneWarning(), dataProperties.getProperty("expectedTelephoneWarning"), "Telephone exceeding the permitted conditions!");
        softAssert.assertEquals(registerPage.retrievePasswordWarning(), dataProperties.getProperty("expectedPasswordWarning"), "Password exceeding the permitted conditions");

        softAssert.assertAll("There are some Warning text that are not showing.");

        //TODO = Test FAILS due to password exceeding the permitted conditions
    }


}
