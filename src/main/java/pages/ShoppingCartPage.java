package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects ----------------------------------------
    @FindBy(xpath = "(//p[text()='Your shopping cart is empty!'])[2]")
    private WebElement warningMessageForEmptyShoppingCart;

    //Actions methods -------------------------------------
    public String verifyTextForWarningMessageForEmptyShoppingCart() {
        return warningMessageForEmptyShoppingCart.getText();
    }

}
