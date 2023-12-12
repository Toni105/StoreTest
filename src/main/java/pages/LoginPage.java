package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    //Objects ----------------------------------------

    @FindBy(id = "input-email")
    private WebElement emailAddressField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
    private WebElement emailPasswordNotMatchingWarning;

    @FindBy(xpath = "//input[@class='form-control']/following-sibling::a[1]")
    private WebElement forgottenPasswordButton;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions methods ------------------------------------
    public void enterEmailAddress(String emailText) {
        emailAddressField.sendKeys(emailText);
    }

    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    public AccountPage clickOnLoginButton() {
        loginButton.click();
        return new AccountPage(driver);
    }

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


}
