package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects ----------------------------------------

    //Buttons
    @FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
    private WebElement checkoutOptionsGuestCheckout;
    @FindBy(xpath = "//*[@id=\"button-account\"]")
    private WebElement continueToCheckoutAsSelectedOption;
    @FindBy(xpath = "//*[@id=\"cart\"]/button")
    private WebElement dropDownCart;
    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")
    private WebElement removeProductFromDropDownCartButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    private WebElement checkoutButton;
    @FindBy(id = "button-payment-address")
    private WebElement continueButton2stepAsLogged;
    @FindBy(id = "button-shipping-method")
    private WebElement continueButton4step;
    @FindBy(id = "button-payment-method")
    private WebElement continueButton5step;
    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
    private WebElement agreeToTermsAndConditions;
    @FindBy(id = "button-confirm")
    private WebElement continueButton6step_ConfirmOrder;
    @FindBy(id = "button-guest")
    private WebElement continueButton2stepAsGuest;

    //Texts
    @FindBy(xpath = "//*[@id=\"collapse-shipping-method\"]/div/p[1]")
    private WebElement checkoutDeliveryMethodText;
    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    private WebElement orderSuccessfullyProcessedText;

    //Fields
    @FindBy(xpath = "//*[@id=\"input-payment-firstname\"]")
    private WebElement firstNameFieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-lastname\"]")
    private WebElement lastNameFieldAsGuest;
    @FindBy(xpath = "(//input[@name='email'])[2]")
    private WebElement emailFieldAsGuest;
    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneFieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-company\"]")
    private WebElement companyFieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-address-1\"]")
    private WebElement address1FieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-address-2\"]")
    private WebElement address2FieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-city\"]")
    private WebElement cityFieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-postcode\"]")
    private WebElement postCodeFieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-country\"]")
    private WebElement countryDropDownFieldAsGuest;
    @FindBy(xpath = "//*[@id=\"input-payment-zone\"]")
    private WebElement regionStateDropDownFieldAsGuest;

    //Banner
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement checkoutBanner;

    //Titles
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4")
    private WebElement step1_CheckoutOption_Title;
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4")
    private WebElement step2_BillingDetails_Title;
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4")
    private WebElement step3_DeliveryDetails_Title;
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4")
    private WebElement step4_DeliveryMethod_Title;
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4")
    private WebElement step5_PaymentMethod_Title;
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/div[1]/h4")
    private WebElement step6_ConfirmOrder_Title;

    //Labels
    @FindBy(xpath = "//*[@id=\"account\"]/div[2]/label")
    private WebElement firstNameLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"account\"]/div[3]/label")
    private WebElement lastNameLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"account\"]/div[4]/label")
    private WebElement emailLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"account\"]/div[5]/label")
    private WebElement telephoneLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[1]/label")
    private WebElement companyLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[2]/label")
    private WebElement address1LabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[3]/label")
    private WebElement address2LabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[4]/label")
    private WebElement cityLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[5]/label")
    private WebElement postCodeLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[6]/label")
    private WebElement countryLabelAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[7]/label")
    private WebElement regionStateLabelAsGuest;

    //Warning messages
    @FindBy(xpath = "//*[@id=\"account\"]/div[2]/div")
    private WebElement firstNameWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"account\"]/div[3]/div")
    private WebElement lastNameWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"account\"]/div[4]/div")
    private WebElement emailWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"account\"]/div[5]/div")
    private WebElement telephoneWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[2]/div")
    private WebElement address1WarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[4]/div")
    private WebElement cityWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[5]/div")
    private WebElement postCodeWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"address\"]/div[7]/div")
    private WebElement regionStateWarningMessageAsGuest;
    @FindBy(xpath = "//*[@id=\"content\"]/p")
    private WebElement shoppingCartIsEmptyMessage;
    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    private WebElement notAgreeToTermsAndConditionsWarningMessage;

    //Actions methods -------------------------------------
    public void clickCheckout() {
        checkoutButton.click();
    }
    public Boolean verifyExistenceOfCheckoutBanner() {
        return checkoutBanner.isDisplayed();
    }
    public void clickContinueButtonAsGuest_2step() {
        continueButton2stepAsGuest.click();
    }

    //Labels
    public String retrieveFirstNameLabelAsGuest() {
        return firstNameLabelAsGuest.getText();
    }
    public String retrieveLastNameLabelAsGuest() {
        return lastNameLabelAsGuest.getText();
    }
    public String retrieveEmailLabelAsGuest() {
        return emailLabelAsGuest.getText();
    }
    public String retrieveTelephoneLabelAsGuest() {
        return telephoneLabelAsGuest.getText();
    }
    public String retrieveCompanyLabelAsGuest() {
        return companyLabelAsGuest.getText();
    }
    public String retrieveAddress1LabelAsGuest() {
        return address1LabelAsGuest.getText();
    }
    public String retrieveAddress2LabelAsGuest() {
        return address2LabelAsGuest.getText();
    }
    public String retrieveCityLabelAsGuest() {
        return cityLabelAsGuest.getText();
    }
    public String retrievePostCodeLabelAsGuest() {
        return postCodeLabelAsGuest.getText();
    }
    public String retrieveCountryLabelAsGuest() {
        return countryLabelAsGuest.getText();
    }
    public String retrieveRegionStateLabelAsGuest() {
        return regionStateLabelAsGuest.getText();
    }

    public boolean retrieveTitle_step1() {return step1_CheckoutOption_Title.isDisplayed();}
    public boolean retrieveTitle_step2() {return step2_BillingDetails_Title.isDisplayed();}
    public boolean retrieveTitle_step3() {return step3_DeliveryDetails_Title.isDisplayed();}
    public boolean retrieveTitle_step4() {return step4_DeliveryMethod_Title.isDisplayed();}
    public boolean retrieveTitle_step5() {return step5_PaymentMethod_Title.isDisplayed();}
    public boolean retrieveTitle_step6() {return step6_ConfirmOrder_Title.isDisplayed();}

    //Placeholders
    public String retrievePlaceholderForFirstNameFieldAsGuest() {
        return firstNameFieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForLastNameFieldAsGuest() {
        return lastNameFieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForEmailFieldAsGuest() {
        return emailFieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForTelephoneFieldAsGuest() {
        return telephoneFieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForCompanyFieldAsGuest() {
        return companyFieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForAddress1FieldAsGuest() {
        return address1FieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForAddress2FieldAsGuest() {
        return address2FieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForCityFieldAsGuest() {
        return cityFieldAsGuest.getAttribute("placeholder");
    }
    public String retrievePlaceholderForPostCodeFieldAsGuest() {
        return postCodeFieldAsGuest.getAttribute("placeholder");
    }

    //Warning Messages
    public String retrieveFirstNameWarningMessageTextAsGuest() {
        return firstNameWarningMessageAsGuest.getText();
    }
    public String retrieveLastNameWarningMessageTextAsGuest() {
        return lastNameWarningMessageAsGuest.getText();
    }
    public String retrieveEmailWarningMessageTextAsGuest() {
        return emailWarningMessageAsGuest.getText();
    }
    public String retrieveTelephoneWarningMessageTextAsGuest() {
        return telephoneWarningMessageAsGuest.getText();
    }
    public String retrieveAddress1WarningMessageTextAsGuest() {
        return address1WarningMessageAsGuest.getText();
    }
    public String retrieveCityWarningMessageTextAsGuest() {
        return cityWarningMessageAsGuest.getText();
    }
    public String retrievePostCodeWarningMessageAsGuest() {
        return postCodeWarningMessageAsGuest.getText();
    }
    public String retrieveRegionStateWarningMessageTextAsGuest() {
        return regionStateWarningMessageAsGuest.getText();
    }

    public boolean retrieveTitleOfCheckoutPage() {
        return checkoutBanner.isDisplayed();
    }

    public String verifyExistenceOfDeliveryMethodText() {
        return checkoutDeliveryMethodText.getText();
    }

    //Combination of action methods ---------------------
    public void selectAndClickContinueToCheckoutOptionsGuestCheckout() {
        checkoutOptionsGuestCheckout.click();
        continueToCheckoutAsSelectedOption.click();
    }

    public void guestFillAllReqFieldsOnlyWithSPACEInStep2_AndClickContinueButton() {
        firstNameFieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        lastNameFieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        emailFieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        telephoneFieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        address1FieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        cityFieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        postCodeFieldAsGuest.sendKeys(Keys.SPACE,Keys.SPACE);
        continueButton2stepAsGuest.click();
    }

    public void guestFillOnlyReqFieldsInStep2_AndClickContinueButton(String firstName, String lastName, String email, String telephone,String address1, String city, String postCode) {
        firstNameFieldAsGuest.sendKeys(firstName);
        lastNameFieldAsGuest.sendKeys(lastName);
        emailFieldAsGuest.sendKeys(email);
        telephoneFieldAsGuest.sendKeys(telephone);
        address1FieldAsGuest.sendKeys(address1);
        cityFieldAsGuest.sendKeys(city);
        postCodeFieldAsGuest.sendKeys(postCode);
        Select choose = new Select(regionStateDropDownFieldAsGuest);
        choose.selectByVisibleText("Bristol");
        continueButton2stepAsGuest.click();
    }
    public String clickAndRemoveProductFromDropDownCart_ThanVerifyEmptyCart() {
        dropDownCart.click();
        removeProductFromDropDownCartButton.click();
        return shoppingCartIsEmptyMessage.getText();
    }

    public String guestCompleteOrder_AndVerifySuccessfullyOrderText(String firstName, String lastName, String email, String telephone,String address1, String city, String postCode) {
        firstNameFieldAsGuest.sendKeys(firstName);
        lastNameFieldAsGuest.sendKeys(lastName);
        emailFieldAsGuest.sendKeys(email);
        telephoneFieldAsGuest.sendKeys(telephone);
        address1FieldAsGuest.sendKeys(address1);
        cityFieldAsGuest.sendKeys(city);
        postCodeFieldAsGuest.sendKeys(postCode);
        Select choose = new Select(regionStateDropDownFieldAsGuest);
        choose.selectByVisibleText("Bristol");
        continueButton2stepAsGuest.click();
        continueButton4step.click();
        agreeToTermsAndConditions.click();
        continueButton5step.click();
        continueButton6step_ConfirmOrder.click();
        return orderSuccessfullyProcessedText.getText();
    }

    public boolean guestCheckout_NotAgreeToTermsAndConditions(String firstName, String lastName, String email, String telephone,String address1, String city, String postCode) {
        firstNameFieldAsGuest.sendKeys(firstName);
        lastNameFieldAsGuest.sendKeys(lastName);
        emailFieldAsGuest.sendKeys(email);
        telephoneFieldAsGuest.sendKeys(telephone);
        address1FieldAsGuest.sendKeys(address1);
        cityFieldAsGuest.sendKeys(city);
        postCodeFieldAsGuest.sendKeys(postCode);
        Select choose = new Select(regionStateDropDownFieldAsGuest);
        choose.selectByVisibleText("Bristol");
        continueButton2stepAsGuest.click();
        continueButton4step.click();
        continueButton5step.click();
        return notAgreeToTermsAndConditionsWarningMessage.isDisplayed();
    }

}
