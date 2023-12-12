package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;

    //Objects -------------------------------

    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationOption;

    @FindBy(css = "aside#column-right>div>a:nth-of-type(13)")
    private WebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    private WebElement logOutConfirmMessage;

    public AccountPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Action methods -------------------------
    public boolean getDisplayStatusOfEditYourAccountInformationOption() {

        return editYourAccountInformationOption.isDisplayed();
    }

    public void clickLogOutButton() {
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
