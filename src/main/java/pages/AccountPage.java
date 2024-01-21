package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects -------------------------------

    //Buttons
    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationOption;
    @FindBy(css = "aside#column-right>div>a:nth-of-type(13)")
    private WebElement logOutButton;

    //Messages
    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    private WebElement logOutConfirmMessage;

    //Action methods -------------------------
    public boolean getDisplayStatusOfEditYourAccountInformationOption() {
        return editYourAccountInformationOption.isDisplayed();
    }

    public void clickLogOut() {
        logOutButton.click();
    }

    public void clickLogOutButtonThanPressBACKButton() {
        logOutButton.click();
        driver.navigate().back();
    }

    public boolean getLogOutConfirmText() {
        return logOutConfirmMessage.isDisplayed();
    }

}
