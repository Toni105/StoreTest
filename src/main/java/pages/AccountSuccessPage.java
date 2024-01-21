package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

    WebDriver driver;

    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Object -------------------------------

    //Text
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement accountSuccessPageHeading;

    //Actions methods -----------------------
    public String retrieveAccountSuccessPageHeading() {
        return accountSuccessPageHeading.getText();
    }


}