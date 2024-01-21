package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Objects ----------------------------------------

    //Text
    @FindBy(className = "panel-body")
    private WebElement addressAndTelephone;

    //Labels
    @FindBy(xpath = "(//label[@class='col-sm-2 control-label'])[1]")
    private WebElement yourNameLabelText;
    @FindBy(xpath = "(//label[@class='col-sm-2 control-label'])[2]")
    private WebElement emailAddressLabelText;
    @FindBy(xpath = "//label[@for='input-enquiry']")
    private WebElement enquiryLabelText;

    //Buttons
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement submitButton;

    //Warning messages
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement SuccessfullySubmitMessage;
    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
    private WebElement emailWarningMessage;
    @FindBy(xpath = "//div[text()='Name must be between 3 and 32 characters!']")
    private WebElement nameWarningMessage;
    @FindBy(xpath = "//div[text()='Enquiry must be between 10 and 3000 characters!']")
    private WebElement enquiryWarningMessage;

    //Fields
    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    private WebElement nameField;
    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    private WebElement emailField;
    @FindBy(tagName = "textarea")
    private WebElement enquiryField;

    //Actions methods -------------------------------------
    public Boolean getAddressAndTelephone() {
        return addressAndTelephone.isDisplayed();
    }
    public String getYourNameLabelText() {
        return yourNameLabelText.getText();
    }
    public String getEmailAddressLabelText() {
        return emailAddressLabelText.getText();
    }
    public String getEnquiryLabelText() {
        return enquiryLabelText.getText();
    }
    public Boolean verifyExistenceOfSubmitButton() {
        return submitButton.isDisplayed();
    }
    public void sendingEnquiryWithEmptyName_EmailAddress_AndEnquiryField() {
        submitButton.click();
    }
    public String getYourNameLabelWarning() {
        return nameWarningMessage.getText();
    }
    public String getEmailAddressWarningText() {
        return emailWarningMessage.getText();
    }
    public String getEnquiryWarningText() {
        return enquiryWarningMessage.getText();
    }

    //Combination of action methods ------------------------
    public Boolean successfullySubmitMessage(String name, String email, String enquiry){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        enquiryField.sendKeys(enquiry);
        submitButton.click();
        return SuccessfullySubmitMessage.isDisplayed();
    }

    public String submitMessage_withoutValidEmail(String name, String invalidEmail, String enquiry){
        nameField.sendKeys(name);
        emailField.sendKeys(invalidEmail);
        enquiryField.sendKeys(enquiry);
        submitButton.click();
        return emailWarningMessage.getText();
    }


}

