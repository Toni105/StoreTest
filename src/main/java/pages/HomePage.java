package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    //Objects -----------------------------------------

    @FindBy(xpath = "//a[.='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    @FindBy(linkText = "Register")
    private WebElement registerOption;

    @FindBy(name = "search")
    private WebElement searchBoxField;

    @FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='form-control']/following-sibling::a[1]")
    private WebElement forgottenPasswordButton;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions methods -------------------------------------

    public void clickOnMyAccount() {
        myAccountDropMenu.click();
    }

    public LoginPage selectLoginOption() {
        loginOption.click();
        return new LoginPage(driver);
    }

    public RegisterPage setRegisterOption() {
        registerOption.click();
        return new RegisterPage(driver);
    }

    public void enterProductNameInSearchBoxField(String productText) {
        searchBoxField.sendKeys(productText);
    }

    public SearchPage clickOnSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public ForgotPasswordPage clickOnForgottenButton() {
        forgottenPasswordButton.click();
        return new ForgotPasswordPage(driver);
    }

    //Combination of action methods ---------------------

    public LoginPage navigateToLoginPage() {
        myAccountDropMenu.click();
        loginOption.click();
        return new LoginPage(driver);
    }

    public RegisterPage navigateToRegisterPage() {
        myAccountDropMenu.click();
        registerOption.click();
        return new RegisterPage(driver);
    }

    public SearchPage searchForAProductAndClickSearchButton(String productText) {
        searchBoxField.sendKeys(productText);
        searchButton.click();
        return new SearchPage(driver);
    }
}

