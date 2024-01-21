package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Utilities;

public class CheckoutTest extends BaseTest {

    WebDriver driver;
    CheckoutPage checkoutPage;
    SearchPage searchPage;
    HomePage homePage;
    ProductDisplayPage productDisplayPage;

    @BeforeMethod
    public void setUp() {
        loadPropertiesFiles();
        driver = initializeBrowserAndOpenApplicationURL(properties.getProperty("browserName"), properties.getProperty("resolutionSize"));
        homePage = new HomePage(driver);
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validProduct"));
        productDisplayPage = searchPage.clickHPLP3065ProductPage();
        checkoutPage = productDisplayPage.addProductInCartAndGoToCheckout();
        checkoutPage.clickCheckout();
        driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"button-account\"]")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyExistenceOfCheckoutBanner() {
        Assert.assertTrue(checkoutPage.verifyExistenceOfCheckoutBanner());
    }

    @Test(priority = 2)
    public void verifyCompletedCheckoutAsGuest() {
        Assert.assertEquals(checkoutPage.guestCompleteOrder_AndVerifySuccessfullyOrderText(Utilities.fakerGenerateFirstName(),Utilities.fakerGenerateLastName(), Utilities.generatedEmailWithTimeStamp(), Utilities.fakerGenerateTelephone(),Utilities.fakerGenerateAddress(),Utilities.fakerGenerateCity(),Utilities.fakerGeneratePostCode()),warningProperties.getProperty("SuccessfulOrderCompleteMessage"));
    }

    @Test(priority =3)
    public void verifyExistenceOfCheckoutTitles_ForAllSteps() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.retrieveTitle_step1());
        softAssert.assertTrue(checkoutPage.retrieveTitle_step2());
        softAssert.assertTrue(checkoutPage.retrieveTitle_step3());
        softAssert.assertTrue(checkoutPage.retrieveTitle_step4());
        softAssert.assertTrue(checkoutPage.retrieveTitle_step5());
        softAssert.assertTrue(checkoutPage.retrieveTitle_step6());
        softAssert.assertAll("Some title/s is missing!");
    }

    @Test(priority = 4)
    public void verifyWarningsTexts_WithoutEnteringAnyFields_In2StepOfCheckoutPage() {
        checkoutPage.clickContinueButtonAsGuest_2step();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.retrieveFirstNameWarningMessageTextAsGuest().contains(warningProperties.getProperty("FirstNameWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveLastNameWarningMessageTextAsGuest().contains(warningProperties.getProperty("LastNameWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveEmailWarningMessageTextAsGuest().contains(warningProperties.getProperty("EmailWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveTelephoneWarningMessageTextAsGuest().contains(warningProperties.getProperty("TelephoneWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveAddress1WarningMessageTextAsGuest().contains(warningProperties.getProperty("Address1WarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveCityWarningMessageTextAsGuest().contains(warningProperties.getProperty("CityWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrievePostCodeWarningMessageAsGuest().contains(warningProperties.getProperty("PostcodeWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveRegionStateWarningMessageTextAsGuest().contains(warningProperties.getProperty("RegionStateWarningMessage")));
        softAssert.assertAll("Some warning/s messages is missing!");
    }

    @Test(priority = 5)
    public void verifyLabelText_In2StepOfCheckoutPage() throws InterruptedException {
        Thread.sleep(500);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.retrieveFirstNameLabelAsGuest().contains(labelProperties.getProperty("FirstNameLabel")));
        softAssert.assertTrue(checkoutPage.retrieveLastNameLabelAsGuest().contains(labelProperties.getProperty("LastNameLabel")));
        softAssert.assertTrue(checkoutPage.retrieveEmailLabelAsGuest().contains(labelProperties.getProperty("EmailLabel")));
        softAssert.assertTrue(checkoutPage.retrieveTelephoneLabelAsGuest().contains(labelProperties.getProperty("TelephoneLabel")));
        softAssert.assertTrue(checkoutPage.retrieveCompanyLabelAsGuest().contains(labelProperties.getProperty("CompanyLabel")));
        softAssert.assertTrue(checkoutPage.retrieveAddress1LabelAsGuest().contains(labelProperties.getProperty("Address1Label")));
        softAssert.assertTrue(checkoutPage.retrieveAddress2LabelAsGuest().contains(labelProperties.getProperty("Address2Label")));
        softAssert.assertTrue(checkoutPage.retrieveCityLabelAsGuest().contains(labelProperties.getProperty("CityLabel")));
        softAssert.assertTrue(checkoutPage.retrievePostCodeLabelAsGuest().contains(labelProperties.getProperty("PostCodeLabel")));
        softAssert.assertTrue(checkoutPage.retrieveCountryLabelAsGuest().contains(labelProperties.getProperty("CountryLabel")));
        softAssert.assertTrue(checkoutPage.retrieveRegionStateLabelAsGuest().contains(labelProperties.getProperty("RegionStateLabel")));
        softAssert.assertAll("Some label/s text is missing!");
    }
    @Test(priority = 6)
    public void verifyPlaceholderText_In2StepOfCheckoutPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForFirstNameFieldAsGuest().contains(placeholderProperties.getProperty("FirstNamePlaceholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForLastNameFieldAsGuest().contains(placeholderProperties.getProperty("LastNamePlaceholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForEmailFieldAsGuest().contains(placeholderProperties.getProperty("EmailPlaceholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForTelephoneFieldAsGuest().contains(placeholderProperties.getProperty("TelephonePlaceholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForCompanyFieldAsGuest().contains(placeholderProperties.getProperty("CompanyPlaceholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForAddress1FieldAsGuest().contains(placeholderProperties.getProperty("Address1Placeholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForAddress2FieldAsGuest().contains(placeholderProperties.getProperty("Address2Placeholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForCityFieldAsGuest().contains(placeholderProperties.getProperty("CityPlaceholder")));
        softAssert.assertTrue(checkoutPage.retrievePlaceholderForPostCodeFieldAsGuest().contains(placeholderProperties.getProperty("PostCodePlaceholder")));
        softAssert.assertAll("Some label/s text is missing!");
    }

    @Test(priority = 7)
    public void verifyTitle_OfCheckoutPage() {
        Assert.assertTrue(checkoutPage.retrieveTitleOfCheckoutPage());
    }

    @Test(priority = 8)
    public void verifyWarningsTexts_WithAllReqFieldsOnlyWithSPACEInStep2() {
        checkoutPage.guestFillAllReqFieldsOnlyWithSPACEInStep2_AndClickContinueButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.retrieveFirstNameWarningMessageTextAsGuest().contains(warningProperties.getProperty("FirstNameWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveLastNameWarningMessageTextAsGuest().contains(warningProperties.getProperty("LastNameWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveEmailWarningMessageTextAsGuest().contains(warningProperties.getProperty("EmailWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveTelephoneWarningMessageTextAsGuest().contains(warningProperties.getProperty("TelephoneWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveAddress1WarningMessageTextAsGuest().contains(warningProperties.getProperty("Address1WarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveCityWarningMessageTextAsGuest().contains(warningProperties.getProperty("CityWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrievePostCodeWarningMessageAsGuest().contains(warningProperties.getProperty("PostcodeWarningMessage")));
        softAssert.assertTrue(checkoutPage.retrieveRegionStateWarningMessageTextAsGuest().contains(warningProperties.getProperty("RegionStateWarningMessage")));
        softAssert.assertAll("Some warning/s messages is missing!");
    }

    @Test(priority = 9)
    public void verifyWarningsTexts_ByEnteringOnlyReqFieldWithBellowMinPermittedRequirement() {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(Utilities.fakerGenerateFirstName(), Utilities.fakerGenerateLastName(), Utilities.fakerGenerateEmail(), dataProperties.getProperty("TelephoneCheckoutBellowMinPermittedRequirement"),dataProperties.getProperty("Address1CheckoutBellowMinPermittedRequirement"),dataProperties.getProperty("CityCheckoutBellowMinPermittedRequirement"),dataProperties.getProperty("PostCodeCheckoutBellowMinPermittedRequirement"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkoutPage.retrieveTelephoneWarningMessageTextAsGuest(),warningProperties.getProperty("TelephoneWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveAddress1WarningMessageTextAsGuest(),warningProperties.getProperty("Address1WarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveCityWarningMessageTextAsGuest(),warningProperties.getProperty("CityWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrievePostCodeWarningMessageAsGuest(),warningProperties.getProperty("PostcodeWarningMessage"));
        softAssert.assertAll("Some warning/s messages is missing!");
    }

    @Test(priority = 10)
    public void verifyContinuingIntoStep3ofCheckout_ByEnteringOnlyReqFieldWithMinPermittedRequirement() throws InterruptedException {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(dataProperties.getProperty("FirstNameCheckoutMinPermittedRequirement"),dataProperties.getProperty("LastNameCheckoutMinPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("TelephoneCheckoutMinPermittedRequirement"),dataProperties.getProperty("Address1CheckoutMinPermittedRequirement"),dataProperties.getProperty("CityCheckoutMinPermittedRequirement"),dataProperties.getProperty("PostCodeCheckoutMinPermittedRequirement"));
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.verifyExistenceOfDeliveryMethodText(),warningProperties.getProperty("ShippingMethodMessage"),"Warning message should not appear!");
    }

    @Test(priority = 11)
    public void verifyContinuingIntoStep3ofCheckout_ByEnteringOnlyReqFieldWithMaxPermittedRequirement() {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(dataProperties.getProperty("FirstNameCheckoutMaxPermittedRequirement"),dataProperties.getProperty("LastNameCheckoutMaxPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("TelephoneCheckoutMaxPermittedRequirement"), dataProperties.getProperty("Address1CheckoutMaxPermittedRequirement"),dataProperties.getProperty("CityCheckoutMaxPermittedRequirement"),dataProperties.getProperty("PostCodeCheckoutMaxPermittedRequirement"));
        Assert.assertEquals(checkoutPage.verifyExistenceOfDeliveryMethodText(),warningProperties.getProperty("ShippingMethodMessage"),"Warning message should not appear!");

        //TODO = The test FAILS due to an impossibility to proceed to the next checkout step, caused by a warning message. Number of characters are maximum allowed, so requirement are meet and it shouldn't invoke warning message!
    }

    @Test(priority = 12)
    public void verifyWarningsTexts_ByEnteringOnlyReqFieldWithExceedingPermittedRequirement() {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(dataProperties.getProperty("FirstNameCheckoutExceedingPermittedRequirement"),dataProperties.getProperty("LastNameCheckoutExceedingPermittedRequirement"), Utilities.fakerGenerateEmail(), dataProperties.getProperty("TelephoneCheckoutExceedingPermittedRequirement"),dataProperties.getProperty("Address1CheckoutExceedingPermittedRequirement"),dataProperties.getProperty("CityCheckoutExceedingPermittedRequirement"),dataProperties.getProperty("PostCodeCheckoutExceedingPermittedRequirement"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkoutPage.retrieveFirstNameWarningMessageTextAsGuest(),warningProperties.getProperty("FirstNameWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveLastNameWarningMessageTextAsGuest(),warningProperties.getProperty("LastNameWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveTelephoneWarningMessageTextAsGuest(),warningProperties.getProperty("TelephoneWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveAddress1WarningMessageTextAsGuest(),warningProperties.getProperty("Address1WarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveCityWarningMessageTextAsGuest(),warningProperties.getProperty("CityWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrievePostCodeWarningMessageAsGuest(),warningProperties.getProperty("PostcodeWarningMessage"));
        softAssert.assertAll("Some warning/s messages is missing!");
    }

    @Test(priority = 13)
    public void verifyWarningsTexts_ByEnteringWrongFormatTypeInReqField() {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(dataProperties.getProperty("FirstNameCheckoutWrongFormatType"),dataProperties.getProperty("LastNameCheckoutWrongFormatType"), dataProperties.getProperty("EmailWrongFormatType"), dataProperties.getProperty("TelephoneCheckoutWrongFormatType"),dataProperties.getProperty("Address1CheckoutWrongFormatType"),dataProperties.getProperty("CityCheckoutWrongFormatType"),dataProperties.getProperty("PostCodeCheckoutWrongFormatType"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkoutPage.retrieveEmailWarningMessageTextAsGuest().contains(warningProperties.getProperty("EmailWarningMessage")));
        softAssert.assertEquals(checkoutPage.retrieveTelephoneWarningMessageTextAsGuest(),warningProperties.getProperty("TelephoneWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveAddress1WarningMessageTextAsGuest(),warningProperties.getProperty("Address1WarningMessage"));
        softAssert.assertEquals(checkoutPage.retrieveCityWarningMessageTextAsGuest(),warningProperties.getProperty("CityWarningMessage"));
        softAssert.assertEquals(checkoutPage.retrievePostCodeWarningMessageAsGuest(),warningProperties.getProperty("PostcodeWarningMessage"));
        softAssert.assertAll("Some warning/s messages is missing!");

        //TODO = Test FAILED due to accepting the wrong format in email, telephone,city, post code and address.
    }

    @Test(priority = 14)
    public void verifyWarningsText_ByEnteringInvalidEmailAddress() {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(Utilities.fakerGenerateFirstName(),Utilities.fakerGenerateLastName(), dataProperties.getProperty("incompleteEmail"), Utilities.fakerGenerateTelephone(),Utilities.fakerGenerateAddress(),Utilities.fakerGenerateCity(),Utilities.fakerGeneratePostCode());
        Assert.assertTrue(checkoutPage.retrieveEmailWarningMessageTextAsGuest().contains(warningProperties.getProperty("EmailWarningMessage")));
    }

    @Test(priority = 15)
    public void verifyCancellationOfCheckout_AfterRemovingProductsInCarts() {
        checkoutPage.guestFillOnlyReqFieldsInStep2_AndClickContinueButton(Utilities.fakerGenerateFirstName(),Utilities.fakerGenerateLastName(), Utilities.generatedEmailWithTimeStamp(), Utilities.fakerGenerateTelephone(),Utilities.fakerGenerateAddress(),Utilities.fakerGenerateCity(),Utilities.fakerGeneratePostCode());
        Assert.assertTrue(checkoutPage.clickAndRemoveProductFromDropDownCart_ThanVerifyEmptyCart().contains(dataProperties.getProperty("emptyCartText")),"CheckoutTest process should stop, shopping cart is empty!");
    }

    @Test(priority = 16)
    public void verifyWarningsTexts_NotAgreeToTermsAndConditions() {
        Assert.assertTrue(checkoutPage.guestCheckout_NotAgreeToTermsAndConditions(Utilities.fakerGenerateFirstName(),Utilities.fakerGenerateLastName(), Utilities.generatedEmailWithTimeStamp(), Utilities.fakerGenerateTelephone(),Utilities.fakerGenerateAddress(),Utilities.fakerGenerateCity(),Utilities.fakerGeneratePostCode()),"Some warning/s messages is missing!");
    }

    //Coming soon more tests...






}
