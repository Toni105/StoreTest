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
    public void verifyRegisteringAnAccount_WithMandatoryFiles() {
        accountSuccessPage = registerPage.fillAllDataInRegistration(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), warningProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");
    }

    @Test(priority = 2)
    public void verifyRegisteringAccount_ByProvidingAllFields() {
        accountSuccessPage = registerPage.fillAllDataInRegistrationIncludingNewsletterOption(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), warningProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");
    }

    @Test(priority = 3)
    public void verifyRegisteringAccount_WithExistingEmailAddress() {
        accountSuccessPage = registerPage.fillAllDataInRegistrationIncludingNewsletterOption(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), dataProperties.getProperty("validEmail"), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));
        Assert.assertEquals(registerPage.retrieveDuplicateEmailAddressWarning(), warningProperties.getProperty("expectedAlreadyRegisteredEmailWarning"), "Warning message is not display!");
    }

    @Test(priority = 4)
    public void verifyRegisteringAccount_WithoutFillingAnyDetails() {
        registerPage.clickContinueButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.retrievePrivacyPolicyWarning(), warningProperties.getProperty("expectedPrivacyPolicyWarning"), "Privacy Policy Warning is not display!");
        softAssert.assertEquals(registerPage.retrieveFirstNameWarning(), warningProperties.getProperty("expectedFirstNameWarning"), "First Name Warning message is not display!");
        softAssert.assertEquals(registerPage.retrieveLastNameWarning(), warningProperties.getProperty("expectedLastNameWarning"), "Last Name Warning message is not display!");
        softAssert.assertEquals(registerPage.retrieveEmailWarning(), warningProperties.getProperty("expectedEmailWarning"), "Warning E-mail message is not display!");
        softAssert.assertEquals(registerPage.retrieveTelephoneWarning(), warningProperties.getProperty("expectedTelephoneWarning"), "Warning Telephone message is not display!");
        softAssert.assertEquals(registerPage.retrievePasswordWarning(), warningProperties.getProperty("expectedPasswordWarning"), "Warning Password message is not display!");
        softAssert.assertAll("There are some Warning text that are not showing.");
    }

    @Test(priority = 5)
    public void verifyRegistering_ByEnteringDifferentPasswordInPassword_AndPasswordConfirmFields() {
        accountSuccessPage = registerPage.fillAllDataInRegistrationWithDifferentPasswordAndConfirmPassword(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"), dataProperties.getProperty("invalidPassword"));
        Assert.assertEquals(registerPage.PasswordAndConfirmPasswordWarning(), warningProperties.getProperty("expectedPasswordNotMatchHeading"), "Warning message is not display!");
    }

    @Test(priority = 6)
    public void retrieveRegisteringHeadingTextForAllText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.retrieveFirstNameHeadingText().contains(placeholderProperties.getProperty("FirstNamePlaceHolderText")));
        softAssert.assertTrue(registerPage.retrieveLastNameHeadingText().contains(placeholderProperties.getProperty("LastNamePlaceHolderText")));
        softAssert.assertTrue(registerPage.retrieveEmailHeadingText().contains(placeholderProperties.getProperty("EmailPlaceHolderText")));
        softAssert.assertTrue(registerPage.retrieveTelephoneHeadingText().contains(placeholderProperties.getProperty("TelephonePlaceHolderText")));
        softAssert.assertTrue(registerPage.retrievePasswordHeadingText().contains(placeholderProperties.getProperty("PasswordPlaceHolderText")));
        softAssert.assertTrue(registerPage.retrievePasswordConfirmHeadingText().contains(placeholderProperties.getProperty("PasswordConfirmPlaceHolderText")));
        softAssert.assertAll("There are some Heading text that are not showing.");
    }

    @Test(priority = 7)
    public void verifyRegistering_ByProvidingAnInvalidEmailAddress() {
        accountSuccessPage = registerPage.fillAllDataInRegistrationIncludingNewsletterOption(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), dataProperties.getProperty("incompleteEmail"), Utilities.fakerGenerateTelephone(), dataProperties.getProperty("password"));
        Assert.assertEquals(registerPage.retrieveEmailWarning(), warningProperties.getProperty("expectedEmailWarning"), "Warning E-mail message is not display!");
    }

    @Test(priority = 8)
    public void verifyRegisteringAccount_ByProvidingAllFields_WithMinimumPermittedCondition() {
        accountSuccessPage = registerPage.fillAllDataInRegistration(dataProperties.getProperty("firstNameMinimumPermittedRequirement"), dataProperties.getProperty("lastNameMinimumPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("telephoneMinimumPermittedRequirement"), dataProperties.getProperty("passwordMinimumPermittedRequirement"));
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), warningProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");
    }

    @Test(priority = 9)
    public void verifyRegisteringAccount_ByProvidingAllFields_WithMaximumPermittedCondition() {
        accountSuccessPage = registerPage.fillAllDataInRegistration(dataProperties.getProperty("firstNameMaximumPermittedRequirement"), dataProperties.getProperty("lastNameMaximumPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("telephoneMaximumPermittedRequirement"), dataProperties.getProperty("passwordMaximumPermittedRequirement"));
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), warningProperties.getProperty("expectedSuccessHeading"), "Account Success page is not display!");
    }

    @Test(priority = 10)
    public void verifyRegisteringAccount_ByProvidingAllFields_WithExceedingPermittedConditions() {
        SoftAssert softAssert = new SoftAssert();
        accountSuccessPage = registerPage.fillAllDataInRegistration(dataProperties.getProperty("firstNameExceedingPermittedRequirement"), dataProperties.getProperty("lastNameExceedingPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("telephoneExceedingPermittedRequirement"), dataProperties.getProperty("passwordExceedingPermittedRequirement"));
        softAssert.assertEquals(registerPage.retrieveFirstNameWarning(), warningProperties.getProperty("expectedFirstNameWarning"), "First Name exceeding the permitted conditions!");
        softAssert.assertEquals(registerPage.retrieveLastNameWarning(), warningProperties.getProperty("expectedLastNameWarning"), "Last Name exceeding the permitted conditions!");
        softAssert.assertEquals(registerPage.retrieveTelephoneWarning(), warningProperties.getProperty("expectedTelephoneWarning"), "Telephone exceeding the permitted conditions!");
        softAssert.assertEquals(registerPage.retrievePasswordWarning(), warningProperties.getProperty("expectedPasswordWarning"), "Password exceeding the permitted conditions");
        softAssert.assertAll("There are some Warning text that are not showing.");

        //TODO = Test FAILS due to password exceeding the permitted conditions.
    }

    @Test(priority = 11)
    public void verifyWhetherMandatoryFieldsInRegisterPage_AreAcceptingOnlySpaces() {
        accountSuccessPage = registerPage.fillAllDataInRegistrationWithOnlySpaces();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.retrieveFirstNameWarning(), warningProperties.getProperty("expectedFirstNameWarning"), "First Name Warning message is not display!");
        softAssert.assertEquals(registerPage.retrieveLastNameWarning(), warningProperties.getProperty("expectedLastNameWarning"), "Last Name Warning message is not display!");
        softAssert.assertEquals(registerPage.retrieveEmailWarning(), warningProperties.getProperty("expectedEmailWarning"), "Warning E-mail message is not display!");
        softAssert.assertEquals(registerPage.retrieveTelephoneWarning(), warningProperties.getProperty("expectedTelephoneWarning"), "Warning Telephone message is not display!");
        softAssert.assertEquals(registerPage.retrievePasswordWarning(), warningProperties.getProperty("expectedPasswordWarning"), "Warning Password message is not display!");
        softAssert.assertAll("There are some Warning text that are not showing.");
    }

    @Test (priority = 12)
    public void verifyTextIntoPasswordAndConfirmedPasswordFields_AreHideItsVisibility() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.retrieveTypeOfPasswordField(),"password", "Text in password field is not hidden !");
        softAssert.assertEquals(registerPage.retrieveTypeOfConfirmedPasswordField(),"password", "Text in confirmed password field is not hidden !");
        softAssert.assertAll("Text in password or/and confirmed password is not hidden !");
    }

    @Test(priority = 13)
    public void verifyBannersText() {
        Assert.assertTrue(registerPage.retrieveRegisterAccountBanner(), "Banner is not showing!");
    }

    @Test(priority = 14)
    public void verifyTitlesText() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(registerPage.retrieveYourPersonalDetailsTitle());
        Assert.assertTrue(registerPage.retrieveYourPasswordTitle());
        Assert.assertTrue(registerPage.retrieveNewsletterTitle());
        softAssert.assertAll("Some title/s are not showing!");
    }

    @Test(priority = 15)
    public void verifyLabelText() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(registerPage.retrieveFirstNameLabel(),labelProperties.getProperty("FirstNameRegisterLabel"));
        Assert.assertEquals(registerPage.retrieveLastNameLabel(),labelProperties.getProperty("LastNameRegisterLabel"));
        Assert.assertEquals(registerPage.retrieveEmailLabel(),labelProperties.getProperty("EmailRegisterLabel"));
        Assert.assertEquals(registerPage.retrieveTelephoneLabel(),labelProperties.getProperty("TelephoneRegisterLabel"));
        Assert.assertEquals(registerPage.retrievePasswordLabel(),labelProperties.getProperty("PasswordRegisterLabel"));
        Assert.assertEquals(registerPage.retrievePasswordConfirmLabel(),labelProperties.getProperty("PasswordConfirmRegisterLabel"));
        Assert.assertEquals(registerPage.retrieveSubscribeLabel(),labelProperties.getProperty("SubscribeRegisterLabel"));
        softAssert.assertAll("Some label/s are not showing!");
    }


}
