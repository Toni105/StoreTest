package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    //Objects ------------------------------------------

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

    @FindBy(name = "agree")
    private WebElement privacyPolicyButton;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continueButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    private WebElement yesNewsletterOption;

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


    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions methods ---------------------------------
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneField.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterPasswordConfirm(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void privacyPolicyAgree() {
        privacyPolicyButton.click();
    }

    public AccountSuccessPage clickContinueButton() {
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public void selectYesNewsletterOption() {
        yesNewsletterOption.click();
    }

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


}
