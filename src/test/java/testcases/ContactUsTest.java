package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

    WebDriver driver;

    ContactUsPage contactUsPage;

    @BeforeMethod
    public void setUp() {
        loadPropertiesFiles();
        driver = initializeBrowserAndOpenApplicationURL(properties.getProperty("browserName"), properties.getProperty("resolutionSize"));
        HomePage homePage = new HomePage(driver);
        contactUsPage = homePage.clickOnContactUsButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyAddressAndTelephone() {
        Assert.assertTrue(contactUsPage.getAddressAndTelephone());
    }

    @Test(priority = 2)
    public void verifyLabels() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(contactUsPage.getYourNameLabelText(),labelProperties.getProperty("NameContactLabel"));
        softAssert.assertEquals(contactUsPage.getEmailAddressLabelText(),labelProperties.getProperty("EmailAddressContactLabel"));
        softAssert.assertEquals(contactUsPage.getEnquiryLabelText(),labelProperties.getProperty("EnquiryContactLabel"));
        softAssert.assertAll("One or more label are not showing!");
    }

    @Test(priority = 3)
    public void verifySubmitButton() {
        Assert.assertTrue(contactUsPage.verifyExistenceOfSubmitButton());
    }

    @Test(priority = 4)
    public void verifySuccessfullySubmitMessage() {
        Assert.assertTrue(contactUsPage.successfullySubmitMessage(dataProperties.getProperty("FirstName"),dataProperties.getProperty("validEmail"),dataProperties.getProperty("descriptionText")));
    }

    @Test(priority = 5)
    public void verifyFailedMessages_withoutValidEmail() {
        Assert.assertEquals(contactUsPage.submitMessage_withoutValidEmail(dataProperties.getProperty("FirstName"),dataProperties.getProperty("incompleteEmail"),dataProperties.getProperty("descriptionText")),warningProperties.getProperty("expectedEmailAddressContactWarning"));
    }

    @Test(priority = 6)
    public void verifyFailedMessages_SendingEnquiryWithEmptyName_EmailAddress_AndEnquiryField() {
        contactUsPage.sendingEnquiryWithEmptyName_EmailAddress_AndEnquiryField();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(contactUsPage.getYourNameLabelWarning(),warningProperties.getProperty("expectedYourNameContactWarning"));
        softAssert.assertEquals(contactUsPage.getEmailAddressWarningText(),warningProperties.getProperty("expectedEmailAddressContactWarning"));
        softAssert.assertEquals(contactUsPage.getEnquiryWarningText(),warningProperties.getProperty("expectedEnquiryContactWarning"));
        softAssert.assertAll("One or more label are not showing!");
    }


}
