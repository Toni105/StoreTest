package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Object -----------------------------------
    @FindBy(xpath = "//h1[text()='Forgot Your Password?']")
    private WebElement forgotPasswordPageHeading;

    //Actions methods --------------------------------
    public String retrieveForgotPasswordPageHeading() {
        return forgotPasswordPageHeading.getText();
    }

}
