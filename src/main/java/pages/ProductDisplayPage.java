package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ProductDisplayPage {

    WebDriver driver;

    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects -------------------------------

    //Image
    @FindBy(xpath = "(//a[@class='thumbnail'])[1]")
    private WebElement productImage;

    @FindBy(xpath = "//div[@class='mfp-figure']//img[1]")
    private WebElement productImageBIG;

    //Warning message
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement successfullyAddToCart;
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement reviewSuccessfullySent;
    @FindBy(xpath = "//div[text()=' Warning: Review Name must be between 3 and 25 characters!']")
    private WebElement warningReviewNameMustBeBetween3And25Characters;
    @FindBy(xpath = "//div[text()=' Warning: Review Text must be between 25 and 1000 characters!']")
    private WebElement warningReviewTextMustBeBetween25And1000Characters;
    @FindBy(xpath = "//div[text()=' Warning: Please select a review rating!']")
    private WebElement warningPleaseSelectRating;
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement productAddToWishListAlert;
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement productAddedToCompareAlert;
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    private WebElement checkoutButton_OnSuccessfullyAddedToCartWarningMessage;

    //Product info text
    @FindBy(xpath = "//h1[text()='HP LP3065']")
    private WebElement productName;
    @FindBy(linkText = "Hewlett-Packard")
    private WebElement brandName;
    @FindBy(xpath = "//li[text()='Product Code:Product 21']")
    private WebElement productCode;
    @FindBy(xpath = "//li[text()='Reward Points:300']")
    private WebElement rewardPoints;
    @FindBy(xpath = "//li[text()='Availability:In Stock']")
    private WebElement availability;
    @FindBy(xpath = "//div[@class='tab-pane active']//p[1]")
    private WebElement description;
    @FindBy(id = "input-quantity")
    private WebElement quantityBar;
    @FindBy(linkText = "Reviews (0)")
    private WebElement reviewTab;

    //Button
    @FindBy(id = "button-cart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[contains(@class,'btn btn-inverse')]")
    private WebElement cartDropDownButton;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement sendReviewButton;
    @FindBy(className = "text-center")
    private WebElement cartDropDown;
    @FindBy(xpath = "(//button[@class='btn btn-default'])[1]")
    private WebElement addToWishButton;
    @FindBy(xpath = "(//button[@class='btn btn-default'])[2]")
    private WebElement compareThisProductButton;

    //Field
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    private WebElement yourNameField;
    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement yourReviewField;
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    private WebElement deliveryDateField;

    //Ratings stars
    @FindBy(xpath = "(//label[text()='Rating']/following::input)[1]")
    private WebElement review1star;

    @FindBy(xpath = "(//label[text()='Rating']/following::input)[2]")
    private WebElement review2star;

    @FindBy(xpath = "(//label[text()='Rating']/following::input)[3]")
    private WebElement review3star;

    @FindBy(xpath = "(//label[text()='Rating']/following::input)[4]")
    private WebElement review4star;

    @FindBy(xpath = "(//label[text()='Rating']/following::input)[5]")
    private WebElement review5star;

    //Labels
    @FindBy(xpath = "(//label[@class='control-label'])[1]")
    private WebElement yourNameLabel;
    @FindBy(xpath = "(//label[@class='control-label'])[2]")
    private WebElement yourReviewLabel;
    @FindBy(xpath = "(//label[@class='control-label'])[3]")
    private WebElement ratingLabel;
    @FindBy(xpath = "//label[@for='input-option225']")
    private WebElement deliveryDateLabel;
    @FindBy(xpath = "//label[@for='input-quantity']")
    private WebElement quantityLabel;

    //Header
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[5]/a/span")
    private WebElement checkoutButtonOnHeader;

    //Action methods -------------------------
    public void clickOnProductImage() {
        productImage.click();
    }
    public String getURLofProductPage() {
        return driver.getCurrentUrl();
    }
    public String getSRCofImage() {
        return productImageBIG.getAttribute("src");
    }
    public String retrieveProductNameText() {
        return productName.getText();
    }
    public String retrieveBrandNameText() {
        return brandName.getText();
    }
    public String retrieveProductCodeText() {
        return productCode.getText();
    }
    public String retrieveRewardPointsText() {
        return rewardPoints.getText();
    }
    public String retrieveAvailabilityText() {
        return availability.getText();
    }
    public String retrieveDescriptionText() {
        return description.getText();
    }
    public String retrieveDefaultQuantityForProduct() {
        return quantityBar.getAttribute("value");
    }
    public void clickCartDropDownButton() {
        cartDropDownButton.click();
    }
    public String retrieveCartDropDownText() {
         return cartDropDown.getText();
    }
    public String retrieveDeliveryDateLabel() {
        return deliveryDateLabel.getText();
    }
    public String retrieveQuantityLabel() {
        return quantityLabel.getText();
    }

    //Combination of action methods -------------------------------------------
    public CheckoutPage addProductInCartAndGoToCheckout() {
        addToCartButton.click();
        checkoutButton_OnSuccessfullyAddedToCartWarningMessage.click();
        return new CheckoutPage(driver);
    }

    public Boolean addProductInCart() {
        addToCartButton.click();
        return successfullyAddToCart.isDisplayed();
    }

    public void addDifferentQuantityOfProductInCart(String quantity) {
        quantityBar.clear();
        quantityBar.sendKeys(quantity);
        addToCartButton.click();
    }

    public String enterName_ReviewText_Rating1Star(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review1star.click();
        sendReviewButton.click();
        return reviewSuccessfullySent.getText();
    }

    public String enterName_ReviewText_Rating2Star(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review2star.click();
        sendReviewButton.click();
        return reviewSuccessfullySent.getText();
    }

    public String enterName_ReviewText_Rating3Star(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review3star.click();
        sendReviewButton.click();
        return reviewSuccessfullySent.getText();
    }

    public String enterName_ReviewText_Rating4Star(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review4star.click();
        sendReviewButton.click();
        return reviewSuccessfullySent.getText();
    }

    public String enterName_ReviewText_Rating5Star(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review5star.click();
        sendReviewButton.click();
        return reviewSuccessfullySent.getText();
    }

    public String verifyWarningSendingReview_WithoutName(String text) {
        reviewTab.click();
        yourReviewField.sendKeys(text);
        review5star.click();
        sendReviewButton.click();
        return warningReviewNameMustBeBetween3And25Characters.getText();
    }

    public String verifyWarningSendingReview_WithoutReviewText(String name) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        review5star.click();
        sendReviewButton.click();
        return warningReviewTextMustBeBetween25And1000Characters.getText();
    }

    public String verifyWarningSendingReview_WithoutRating(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        sendReviewButton.click();
        return warningPleaseSelectRating.getText();
    }

    public String verifyWarningSendingReview_BelowMinAndOverMaxReqText(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review5star.click();
        sendReviewButton.click();
        return warningReviewTextMustBeBetween25And1000Characters.getText();
    }

    public String reviewMinAndMaxReqText(String name, String text) {
        reviewTab.click();
        yourNameField.sendKeys(name);
        yourReviewField.sendKeys(text);
        review5star.click();
        sendReviewButton.click();
        return reviewSuccessfullySent.getText();
    }

    public String enterName_ReviewWithout_Name_ReviewText_AndRating() {
        reviewTab.click();
        sendReviewButton.click();
        return warningPleaseSelectRating.getText();
    }

    public String retrieveNameLabelText(){
        reviewTab.click();
        return yourNameLabel.getText();
    }

    public String retrieveReviewLabelText(){
        reviewTab.click();
        return yourReviewLabel.getText();
    }

    public String retrieveRatingLabelText(){
        reviewTab.click();
        return ratingLabel.getText();
    }

    public Boolean addProductToWishList(){
        addToWishButton.click();
        return productAddToWishListAlert.isDisplayed();
    }

    public Boolean addProductToCompare(){
        compareThisProductButton.click();
        return productAddedToCompareAlert.isDisplayed();
    }

    public Boolean setDeliveryData(String date) {
        deliveryDateField.clear();
        deliveryDateField.sendKeys(date);
        addToCartButton.click();
        return successfullyAddToCart.isDisplayed();
    }

    //Date methods
    public String presentDate() {
        Date curentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(curentDate);
    }

    public String pastDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate yesterdayDate = currentDate.minusDays(1);
        return String.valueOf(yesterdayDate);
    }

    public String futureDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(1);
        return String.valueOf(futureDate);
    }

}
