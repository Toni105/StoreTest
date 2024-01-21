package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Object -------------------------------

    //HP product
    @FindBy(linkText = "HP LP3065")
    private WebElement validHPProduct;
    @FindBy(xpath = "//div[@class='caption']//a[1]")
    private WebElement HPLP3065ProductPage;

    //iMac product
    @FindBy(xpath = "//a[contains(text(),'iMac')]")
    private  WebElement iMacProduct;
    @FindBy( xpath = "//a[text()='MacBook']")
    private WebElement macBookProduct;

    //Warning message
    @FindBy(xpath = "(//div[@id='content']//p)[2]")
    private WebElement noProductMessage;
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement successfullyAddedProductInCart;

    @FindBy(xpath = "//*[@id=\"product-search\"]/div[1]")
    private WebElement successfullyAddedToWishList;

    //List of Mac products
    @FindBy(className = "button-group")
    List<WebElement> numberOfMacProduct;

    //Fields
    @FindBy(xpath = "(//input[@name='search'])[2]")
    private WebElement searchBarOnSearchPage;

    //Buttons
    @FindBy(id = "description")
    private WebElement searchInProductDescriptionButton;
    @FindBy(id = "button-search")
    private WebElement searchButton;
    @FindBy(id = "list-view")
    private WebElement changeGridToListViewButton;
    @FindBy(xpath = "(//div[@class='button-group']//button)[2]")
    private WebElement addToWishListButton;
    @FindBy(xpath = "//span[text()='Wish List (1)']")
    private WebElement WishListButton;
    @FindBy(xpath = "(//div[@class='button-group']//button)[1]")
    private WebElement addProductInCart;
    @FindBy(id = "category_id")
    private WebElement dropDownMenuOfCategoryChoose;
    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    private WebElement categoryChoose;

    //Actions methods -------------------------
    public boolean displayStatusOfHPValidProduct() {
        return validHPProduct.isDisplayed();
    }

    public String retrieveNoProductMessageText() {
        return noProductMessage.getText();
    }

    public String retrieveNumberOfMacProduct() {
        List<WebElement> list = numberOfMacProduct ;
        return String.valueOf(list.size());
    }

    public boolean getDisplayStatusOfiMacProduct() {
        return iMacProduct.isDisplayed();
    }

    public ProductDisplayPage clickHPLP3065ProductPage(){
        HPLP3065ProductPage.click();
        return new ProductDisplayPage(driver);
    }

    public WishListPage AddProductToWishList_AndGoToWishListPage() {
        addToWishListButton.click();
        WishListButton.click();
        return new WishListPage(driver);
    }

    //Combination of action methods -------------------------------------------
    public boolean addProductInCartAndRetrieveExistenceOfSuccessfullyAddedProductInCartMessage() {
        addProductInCart.click();
        return successfullyAddedProductInCart.isDisplayed();
    }

    public void searchForProductByDescriptions(String productText){
        searchBarOnSearchPage.clear();
        searchBarOnSearchPage.sendKeys(productText);
        searchInProductDescriptionButton.click();
        searchButton.click();
    }

    public void searchForProductBySelectingTheCategoryOfProduct(String productText,Integer numberOfCategoryOfProduct){
        searchBarOnSearchPage.clear();
        WebElement category_choose = categoryChoose;
        Select izabrano = new Select(category_choose);
        izabrano.selectByIndex(numberOfCategoryOfProduct);
        searchBarOnSearchPage.sendKeys(productText);
        searchButton.click();
    }

    public String actualLocationOfProduct() {
        changeGridToListViewButton.click();
        WebElement element = macBookProduct;

        Point p = element.getLocation();
        String actual = ("x=" + p.getX() +", y=" + p.getY());
        return actual;
    }

}
