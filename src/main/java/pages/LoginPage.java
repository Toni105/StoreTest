package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects ----------------------------------------

    //Field
    @FindBy(id = "input-email")
    private WebElement emailAddressField;
    @FindBy(id = "input-password")
    private WebElement passwordField;

    //Button
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@class='form-control']/following-sibling::a[1]")
    private WebElement forgottenPasswordButton;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement continueToRegisterAccountButton;
    @FindBy(css = "aside#column-right>div>a:nth-of-type(13)")
    private WebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
    private WebElement logoButton;

    //Warning message
    @FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
    private WebElement emailPasswordNotMatchingWarning;

    //Banner
    @FindBy(xpath = "//h2[text()='New Customer']")
    private WebElement newCustomerBanner;
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    private WebElement returningCustomerBanner;

    //Title
    @FindBy(xpath = "//strong[text()='Register Account']")
    private WebElement registerAccountTitle;
    @FindBy(xpath = "//strong[text()='Register Account']")
    private WebElement iamReturningCustomerTitle;

    //Text
    @FindBy(xpath = "(//h2[text()='New Customer']/following-sibling::p)[2]")
    private WebElement registerAccountDescription;

    //Label
    @FindBy(xpath = "(//label[@class='control-label'])[1]")
    private WebElement emailAddressLabel;
    @FindBy(xpath = "(//label[@class='control-label'])[2]")
    private WebElement passwordLabel;
    @FindBy(xpath = "(//a[@class='list-group-item'])[1]")
    private WebElement loginColumnLabel;
    @FindBy(xpath = "(//a[@class='list-group-item'])[2]")
    private WebElement registerColumnLabel;
    @FindBy(xpath = "(//a[@class='list-group-item'])[3]")
    private WebElement forgottenPasswordColumnLabel;
    @FindBy(xpath = "(//a[@class='list-group-item']/following-sibling::a)[3]")
    private WebElement myAccountColumnLabel;
    @FindBy(xpath = "//a[contains(text(),'Address Book')]")
    private WebElement addressBookColumnLabel;
    @FindBy(css = "aside#column-right>div>a:nth-of-type(6)")
    private WebElement wishListColumnLabel;
    @FindBy(css = "aside#column-right>div>a:nth-of-type(7)")
    private WebElement orderHistoryColumnLabel;
    @FindBy(xpath = "//a[contains(text(),'Downloads')]")
    private WebElement downloadsColumnLabel;
    @FindBy(xpath = "//a[contains(text(),'Recurring payments')]")
    private WebElement recurringPaymentsColumnLabel;
    @FindBy(xpath = "//a[contains(text(),'Reward Points')]")
    private WebElement rewardPointsColumnLabel;
    @FindBy(css = "aside#column-right>div>a:nth-of-type(11)")
    private WebElement returnsColumnLabel;
    @FindBy(xpath = "//a[contains(text(),'Transactions')]")
    private WebElement transactionColumnLabel;
    @FindBy(css = "aside#column-right>div>a:nth-of-type(13)")
    private WebElement newsletterColumnLabel;

    //Actions methods ------------------------------------
    public String retrieveEmailPasswordNotMatchingWarningMessageText() {
        return emailPasswordNotMatchingWarning.getText();
    }
    public ForgotPasswordPage clickOnForgottenPasswordButton() {
        forgottenPasswordButton.click();
        return new ForgotPasswordPage(driver);
    }
    public String retrieveEmailAddressHeadingText() {
        return emailAddressField.getAttribute("placeholder");
    }
    public String retrievePasswordHeadingText() {
        return passwordField.getAttribute("placeholder");
    }
    public String retrieveTypeOfPasswordField() {
        return passwordField.getAttribute("type");
    }
    public Boolean retrieveNewCustomerBanner() {
        return newCustomerBanner.isDisplayed();
    }
    public Boolean retrieveReturningCustomerBanner() {
        return returningCustomerBanner.isDisplayed();
    }
    public Boolean retrieveRegisterAccountTitle() {
        return registerAccountTitle.isDisplayed();
    }
    public Boolean retrieveIamReturningCustomerTitle() {
        return iamReturningCustomerTitle.isDisplayed();
    }
    public Boolean retrieveContinueToRegisterAccountButton() {
        return continueToRegisterAccountButton.isDisplayed();
    }
    public Boolean retrieveLoginButton() {
        return loginButton.isDisplayed();
    }
    public String retrieveRegisterAccountDescription() {
        return registerAccountDescription.getText();
    }
    public String retrieveEmailAddressLabel() {
        return emailAddressLabel.getText();
    }
    public String retrievePasswordLabel() {
        return passwordLabel.getText();
    }
    public String retrieveLoginColumnLabel() {
        return loginColumnLabel.getText();
    }
    public String retrieveRegisterColumnLabel() {
        return registerColumnLabel.getText();
    }
    public String retrieveForgottenPasswordColumnLabel() {
        return forgottenPasswordColumnLabel.getText();
    }
    public String retrieveMyAccountColumnLabel() {
        return myAccountColumnLabel.getText();
    }
    public String retrieveAddressBookColumnLabel() {
        return addressBookColumnLabel.getText();
    }
    public String retrieveWishListColumnLabel() {
        return wishListColumnLabel.getText();
    }
    public String retrieveOrderHistoryColumnLabel() {
        return orderHistoryColumnLabel.getText();
    }
    public String retrieveDownloadsColumnLabel() {
        return downloadsColumnLabel.getText();
    }
    public String retrieveRecurringPaymentsColumnLabel() {
        return recurringPaymentsColumnLabel.getText();
    }
    public String retrieveRewardPointsColumnLabel() {
        return rewardPointsColumnLabel.getText();
    }
    public String retrieveReturnsColumnLabel() {
        return returnsColumnLabel.getText();
    }
    public String retrieveTransactionColumnLabel() {
        return transactionColumnLabel.getText();
    }
    public String retrieveNewsletterColumnLabel() {
        return newsletterColumnLabel.getText();
    }
    public void clickLogoButton() {
        logoButton.click();
    }
    public void clickLogOutButton() {
        logoutButton.click();
    }
    public void clickOnLoginButton() {
        loginButton.click();
        new AccountPage(driver);
    }

    //Combination of action methods -----------------------------
    public AccountPage enterEmailFieldAndPasswordFieldThanClickLoginButton(String emailText, String passwordText) {
        emailAddressField.sendKeys(emailText);
        passwordField.sendKeys(passwordText);
        loginButton.click();
        return new AccountPage(driver);
    }

    public AccountPage enterEmailFieldThanPressTABEnterPasswordFieldThanPressENTERToLogin(String emailText, String passwordText) {
        emailAddressField.sendKeys(emailText);
        emailAddressField.sendKeys(Keys.TAB);
        passwordField.sendKeys(passwordText);
        loginButton.sendKeys(Keys.ENTER);
        return new AccountPage(driver);
    }

    public Boolean openTwoTabs_ThanLogOutOnFirstOne_SwitchOnSecond_ThanRefresh_AndVerifyIsSecondLogOut() {
        registerColumnLabel.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<String>(windowHandles);
        clickLogOutButton();
        driver.switchTo().window(windows.get(1));
        driver.navigate().refresh();
        return loginButton.isDisplayed();
    }

}
