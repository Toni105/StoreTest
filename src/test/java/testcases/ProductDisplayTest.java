package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ProductDisplayPage;
import pages.SearchPage;

public class ProductDisplayTest extends BaseTest {

    SearchPage searchPage;

    HomePage homePage;

    ProductDisplayPage productDisplayPage;
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        loadPropertiesFiles();
        driver = initializeBrowserAndOpenApplicationURL(properties.getProperty("browserName"), properties.getProperty("resolutionSize"));
        homePage = new HomePage(driver);
        searchPage = homePage.searchForAProductAndClickSearchButton(dataProperties.getProperty("validProduct"));
        productDisplayPage = searchPage.clickHPLP3065ProductPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(priority = 1)
    public void verifyURLofProductPage() {
        Assert.assertEquals(productDisplayPage.getURLofProductPage(),dataProperties.getProperty("URLofHPProductPage"));
    }

    @Test(priority = 2)
    public void verifyClickableProductImage() {
        productDisplayPage.clickOnProductImage();
        Assert.assertEquals(productDisplayPage.getSRCofImage(),dataProperties.getProperty("expectedSRCofMainImage"));
    }

    @Test(priority = 3)
    public void verifyThatProductName_Brand_ProductCode_RewardsPoints_Availability_And_Price_LabelAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productDisplayPage.retrieveProductNameText().contains(dataProperties.getProperty("productName")));
        softAssert.assertTrue(productDisplayPage.retrieveBrandNameText().contains(dataProperties.getProperty("brand")));
        softAssert.assertTrue(productDisplayPage.retrieveProductCodeText().contains(dataProperties.getProperty("productCode")));
        softAssert.assertTrue(productDisplayPage.retrieveRewardPointsText().contains(dataProperties.getProperty("rewardPoints")));
        softAssert.assertTrue(productDisplayPage.retrieveAvailabilityText().contains(dataProperties.getProperty("availability")));
        softAssert.assertAll("Some labels in the product page are not showing!");
    }

    @Test(priority = 4)
    public void verifyThatDescriptionIsDisplayed() {
        Assert.assertEquals(productDisplayPage.retrieveDescriptionText(),dataProperties.getProperty("descriptionText"));
    }

    @Test(priority = 5)
    public void verifyAdding1ProductInCart() {
        Assert.assertTrue(productDisplayPage.addProductInCart());
    }

    @Test(priority = 6)
    public void verifyThatDefaultQuantityForProductIs1() {
        Assert.assertTrue(productDisplayPage.retrieveDefaultQuantityForProduct().contains(placeholderProperties.getProperty("DefaultQuantityForProduct")));
    }

    @Test(priority = 7)
    public void verifyThatZeroQuantityIsNotAllowed() {
        productDisplayPage.addDifferentQuantityOfProductInCart("0");
        productDisplayPage.clickCartDropDownButton();
        Assert.assertTrue(productDisplayPage.retrieveCartDropDownText().contains(dataProperties.getProperty("emptyCartText")));
    }

    @Test(priority = 8)
    public void verifyThatNegativeQuantityIsNotAllowed() {
        productDisplayPage.addDifferentQuantityOfProductInCart("-1");
        productDisplayPage.clickCartDropDownButton();
        Assert.assertTrue(productDisplayPage.retrieveCartDropDownText().contains(dataProperties.getProperty("emptyCartText")));
    }

    @Test(priority = 9)
    public void verifySuccessfulSendReview_1Star() {
        Assert.assertTrue(productDisplayPage.enterName_ReviewText_Rating1Star(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 10)
    public void verifySuccessfulSendReview_2Star() {
        Assert.assertTrue(productDisplayPage.enterName_ReviewText_Rating2Star(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 11)
    public void verifySuccessfulSendReview_3Star() {
        Assert.assertTrue(productDisplayPage.enterName_ReviewText_Rating3Star(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 12)
    public void verifySuccessfulSendReview_4Star() {
        Assert.assertTrue(productDisplayPage.enterName_ReviewText_Rating4Star(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 13)
    public void verifySuccessfulSendReview_5Star() {
        Assert.assertTrue(productDisplayPage.enterName_ReviewText_Rating5Star(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 14)
    public void verifySendingReview_WithoutName() {
        Assert.assertTrue(productDisplayPage.verifyWarningSendingReview_WithoutName(dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedNoNameWarning")));
    }

    @Test(priority = 15)
    public void verifySendingReview_WithoutReviewText(){
        Assert.assertTrue(productDisplayPage.verifyWarningSendingReview_WithoutReviewText(dataProperties.getProperty("reviewName")).contains(warningProperties.getProperty("expectedTextReqNotMeetWarning")));
    }

    @Test(priority = 16)
    public void verifySendingReview_WitMinimumReqReviewText(){
        Assert.assertTrue(productDisplayPage.reviewMinAndMaxReqText(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 17)
    public void verifySendingReview_BelowMinimumReqReviewText(){
        Assert.assertTrue(productDisplayPage.verifyWarningSendingReview_BelowMinAndOverMaxReqText(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_24Char")).contains(warningProperties.getProperty("expectedTextReqNotMeetWarning")));
    }

    @Test(priority = 18)
    public void verifySendingReview_WitMaxReqReviewText(){
        Assert.assertTrue(productDisplayPage.reviewMinAndMaxReqText(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_1000Char")).contains(warningProperties.getProperty("expectedSuccessfullySent")));
    }

    @Test(priority = 19)
    public void verifySendingReview_OverMaxReqReviewText(){
        Assert.assertTrue(productDisplayPage.verifyWarningSendingReview_BelowMinAndOverMaxReqText(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_1001Char")).contains(warningProperties.getProperty("expectedTextReqNotMeetWarning")));
    }

    @Test(priority = 20)
    public void verifySendingReview_WithoutRating() {
        Assert.assertTrue(productDisplayPage.verifyWarningSendingReview_WithoutRating(dataProperties.getProperty("reviewName"),dataProperties.getProperty("reviewText_25Char")).contains(warningProperties.getProperty("expectedNoRatingWarning")));
    }

    @Test(priority = 21)
    public void verifySendingReviewWithout_Name_ReviewText_AndRating() {
        Assert.assertTrue(productDisplayPage.enterName_ReviewWithout_Name_ReviewText_AndRating().contains(warningProperties.getProperty("expectedNoRatingWarning")));
    }

    @Test(priority = 22)
    public void verifyProductPageLabelText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productDisplayPage.retrieveDeliveryDateLabel().contains(labelProperties.getProperty("DeliveryDateProductPageLabel")));
        softAssert.assertTrue(productDisplayPage.retrieveQuantityLabel().contains(labelProperties.getProperty("QuantityProductPageLabel")));
        softAssert.assertAll("Some label/s text is not showing!");
    }

    @Test(priority = 23)
    public void verifyReviewLabelsTexts() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productDisplayPage.retrieveNameLabelText().contains(labelProperties.getProperty("NameReviewLabel")));
        softAssert.assertTrue(productDisplayPage.retrieveReviewLabelText().contains(labelProperties.getProperty("ReviewLabel")));
        softAssert.assertTrue(productDisplayPage.retrieveRatingLabelText().contains(labelProperties.getProperty("RatingReviewLabel")));
        softAssert.assertAll("Some label/s text is not showing!");
    }

    @Test(priority = 24)
    public void addProductToWishList() {
        Assert.assertTrue(productDisplayPage.addProductToWishList());
    }

    @Test(priority = 25)
    public void compareThisProduct() {
        Assert.assertTrue(productDisplayPage.addProductToCompare());
    }

    @Test(priority = 26)
    public void verifyPossibilityOfDeliveryOnPastDay() {
        Assert.assertFalse(productDisplayPage.setDeliveryData(productDisplayPage.pastDate()));
        //TODO= delivery should not be possible in the past tense!
    }

    @Test(priority = 27)
    public void verifyPossibilityOfDeliveryOnPresentDay() {
        Assert.assertTrue(productDisplayPage.setDeliveryData(productDisplayPage.presentDate()));
    }

    @Test(priority = 28)
    public void verifyPossibilityOfDeliveryOnFutureDay() {
        Assert.assertTrue(productDisplayPage.setDeliveryData(productDisplayPage.futureDate()));
    }

}
