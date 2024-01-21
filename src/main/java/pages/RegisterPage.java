package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects ------------------------------------------

    //Fields
    @FindBy(id = "input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;

    //Buttons
    @FindBy(name = "agree")
    private WebElement privacyPolicyButton;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continueButton;
    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    private WebElement yesNewsletterOption;

    //Warning messages
    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    private WebElement duplicateEmailAddressWarning;
    @FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
    private WebElement privacyPolicyWarning;
    @FindBy(xpath = "(//div[@class='text-danger'])[1]")
    private WebElement firstNameWarning;
    @FindBy(xpath = "(//div[@class='text-danger'])[2]")
    private WebElement lastNameWarning;
    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement emailWarning;
    @FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
    private WebElement telephoneWarning;
    @FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
    private WebElement passwordWarning;
    @FindBy(className = "text-danger")
    private WebElement passwordAndConfirmPasswordDifferentWarning;

    //Banner
    @FindBy(xpath = "//h1[text()='Register Account']")
    private WebElement registerAccountBanner;

    //Titles
    @FindBy(xpath = "//legend[text()='Your Personal Details']")
    private WebElement yourPersonalDetailsTitle;
    @FindBy(xpath = "//legend[text()='Your Password']")
    private WebElement yourPasswordTitle;
    @FindBy(xpath = "//legend[text()='Newsletter']")
    private WebElement newsletterTitle;

    //Labels
    @FindBy(xpath = "(//label[@class='col-sm-2 control-label'])[2]")
    private WebElement firstNameLabel;
    @FindBy(xpath = "(//label[@class='col-sm-2 control-label'])[3]")
    private WebElement lastNameLabel;
    @FindBy(xpath = "//label[@for='input-email']")
    private WebElement emailLabel;
    @FindBy(xpath = "//label[@for='input-telephone']")
    private WebElement telephoneLabel;
    @FindBy(xpath = "//label[@for='input-password']")
    private WebElement passwordLabel;
    @FindBy(xpath = "//label[@for='input-confirm']")
    private WebElement passwordConfirmLabel;
    @FindBy(xpath = "//label[text()='Subscribe']")
    private WebElement subscribeLabel;

    //Actions methods ---------------------------------
    public String retrieveDuplicateEmailAddressWarning() {
        return duplicateEmailAddressWarning.getText();
    }
    public String retrievePrivacyPolicyWarning() {
        return privacyPolicyWarning.getText();
    }
    public String retrieveFirstNameWarning() {
        return firstNameWarning.getText();
    }
    public String retrieveLastNameWarning() {
        return lastNameWarning.getText();
    }
    public String retrieveEmailWarning() {
        return emailWarning.getText();
    }
    public String retrieveTelephoneWarning() {
        return telephoneWarning.getText();
    }
    public String retrievePasswordWarning() {
        return passwordWarning.getText();
    }
    public String PasswordAndConfirmPasswordWarning() {
        return passwordAndConfirmPasswordDifferentWarning.getText();
    }

    public String retrieveFirstNameHeadingText() {
        return firstNameField.getAttribute("placeholder");
    }
    public String retrieveLastNameHeadingText() {
        return lastNameField.getAttribute("placeholder");
    }
    public String retrieveEmailHeadingText() {
        return emailField.getAttribute("placeholder");
    }
    public String retrieveTelephoneHeadingText() {
        return telephoneField.getAttribute("placeholder");
    }
    public String retrievePasswordHeadingText() {
        return passwordField.getAttribute("placeholder");
    }
    public String retrievePasswordConfirmHeadingText() {
        return confirmPasswordField.getAttribute("placeholder");
    }

    public String retrieveTypeOfPasswordField() {
        return passwordField.getAttribute("type");
    }
    public String retrieveTypeOfConfirmedPasswordField() {
        return confirmPasswordField.getAttribute("type");
    }

    public Boolean retrieveRegisterAccountBanner() {
        return registerAccountBanner.isDisplayed();
    }
    public Boolean retrieveYourPersonalDetailsTitle() {
        return yourPersonalDetailsTitle.isDisplayed();
    }
    public Boolean retrieveYourPasswordTitle() {
        return yourPasswordTitle.isDisplayed();
    }
    public Boolean retrieveNewsletterTitle() {
        return newsletterTitle.isDisplayed();
    }

    public String retrieveFirstNameLabel() {
        return firstNameLabel.getText();
    }
    public String retrieveLastNameLabel() {
        return lastNameLabel.getText();
    }
    public String retrieveEmailLabel() {
        return emailLabel.getText();
    }
    public String retrieveTelephoneLabel() {
        return telephoneLabel.getText();
    }
    public String retrievePasswordLabel() {
        return passwordLabel.getText();
    }
    public String retrievePasswordConfirmLabel() {
        return passwordConfirmLabel.getText();
    }
    public String retrieveSubscribeLabel() {
        return subscribeLabel.getText();
    }

    //Combination of action methods ---------------------------------------
    public AccountSuccessPage fillAllDataInRegistration(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {

        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        privacyPolicyButton.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public AccountSuccessPage fillAllDataInRegistrationWithOnlySpaces() {

        firstNameField.sendKeys(Keys.SPACE);
        lastNameField.sendKeys(Keys.SPACE);
        emailField.sendKeys(Keys.SPACE);
        telephoneField.sendKeys(Keys.SPACE);
        passwordField.sendKeys(Keys.SPACE);
        confirmPasswordField.sendKeys(Keys.SPACE);
        privacyPolicyButton.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public AccountSuccessPage fillAllDataInRegistrationIncludingNewsletterOption(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {

        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        privacyPolicyButton.click();
        yesNewsletterOption.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public AccountSuccessPage fillAllDataInRegistrationWithDifferentPasswordAndConfirmPassword(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText, String confirmPasswordText) {

        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(confirmPasswordText);
        privacyPolicyButton.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public void clickContinueButton() {
        continueButton.click();
        new AccountSuccessPage(driver);
    }

}
