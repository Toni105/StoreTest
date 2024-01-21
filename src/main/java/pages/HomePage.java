package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects -----------------------------------------

    //Drop down menu
    @FindBy(xpath = "//a[.='My Account']")
    private WebElement myAccountDropMenu;
    @FindBy(linkText = "Login")
    private WebElement loginOption;
    @FindBy(linkText = "Register")
    private WebElement registerOption;
    @FindBy(xpath = "//a[text()='Desktops']")
    private WebElement subCategoryDesktopsDropDownMenu;
    @FindBy(xpath = "//a[contains(text(),'Mac (1)')]")
    private WebElement subCategoryMacDropDownMenu;
    @FindBy(id = "cart-total")
    private WebElement cartTotal;
    @FindBy(xpath = "//*[@id=\"cart-total\"]")
    private WebElement cartTotalDropDown;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
    private WebElement myAccountLogOutDropDown;

    //Fields
    @FindBy(name = "search")
    private WebElement searchBoxField;

    //Buttons
    @FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@class='form-control']/following-sibling::a[1]")
    private WebElement forgottenPasswordButton;
    @FindBy(xpath = "//a[contains(text(),'Contact Us')]")
    private WebElement contactUsButton;
    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")
    private  WebElement cartTotalDropDown_DeleteButton;
    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    private WebElement ButtonAddingProductFromFeaturedSectionToCart;

    //Text
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement successfullyAddedProductInCart;
    @FindBy(xpath = "//span[text()='Shopping Cart']")
    private WebElement checkoutHeaderOption;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement myAccountHeaderDropDown;

    //Actions methods -------------------------------------
    public SearchPage clickOnSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public String searchBarHeadingText() {
        return searchBoxField.getAttribute("placeholder");
    }

    public ContactUsPage clickOnContactUsButton() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    public ShoppingCartPage clickOnCheckoutButton() {
        checkoutHeaderOption.click();
        return new ShoppingCartPage(driver);
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

    public SearchPage clickMacSubCategoryFromDropDownMenu() {
        subCategoryDesktopsDropDownMenu.click();
        subCategoryMacDropDownMenu.click();
        return new SearchPage(driver);
    }

    public boolean clickButtonAndVerifyAddingProductFromFeaturedSectionToCart() {
        ButtonAddingProductFromFeaturedSectionToCart.click();
        return successfullyAddedProductInCart.isDisplayed();
    }

    public String clickDropDownMenuAndVerifyText() {
        cartTotal.click();
        return cartTotalDropDown.getText();
    }

    public boolean clickDropDownMenu_ClickDeleteProductButton_AndVerifyText() {
        cartTotal.click();
        cartTotalDropDown_DeleteButton.click();
        return cartTotalDropDown.isDisplayed();
    }

    public void clickMyAccount_AndClickLogoutOnHeader() {
        myAccountHeaderDropDown.click();
        myAccountLogOutDropDown.click();
    }


}

