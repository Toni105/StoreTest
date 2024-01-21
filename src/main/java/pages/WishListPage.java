package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Object -------------------------------
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")
    private WebElement addToCartButton;

    //Actions methods -------------------------
    public ProductDisplayPage clickAddToCartButton() {
        addToCartButton.click();
        return new ProductDisplayPage(driver);
    }

}
