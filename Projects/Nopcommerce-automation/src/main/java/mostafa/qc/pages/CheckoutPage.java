package mostafa.qc.pages;

import mostafa.qc.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    // Billing Address
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement billingFirstName;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement billingLastName;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement billingEmail;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingCountry;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement billingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement billingAddress1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement billingZip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement billingPhone;

    // Navigation buttons
    @FindBy(css = "#billing-buttons-container .new-address-next-step-button")
    private WebElement billingContinueBtn;

    @FindBy(css = "#shipping-method-buttons-container .button-1")
    private WebElement shippingMethodContinueBtn;

    @FindBy(css = "#payment-method-buttons-container .button-1")
    private WebElement paymentMethodContinueBtn;

    @FindBy(css = "#payment-info-buttons-container .button-1")
    private WebElement paymentInfoContinueBtn;

    @FindBy(css = "#confirm-order-buttons-container .button-1")
    private WebElement confirmOrderBtn;

    // Order confirmation
    @FindBy(css = ".order-completed .title strong")
    private WebElement orderConfirmationTitle;

    @FindBy(css = ".order-number strong")
    private WebElement orderNumber;

    // Payment
    @FindBy(id = "paymentmethod_0")
    private WebElement cashOnDeliveryRadio;

    @FindBy(id = "paymentmethod_1")
    private WebElement creditCardRadio;

    // Credit Card fields
    @FindBy(id = "CardholderName")
    private WebElement cardHolderName;

    @FindBy(id = "CardNumber")
    private WebElement cardNumber;

    @FindBy(id = "ExpireMonth")
    private WebElement expireMonth;

    @FindBy(id = "ExpireYear")
    private WebElement expireYear;

    @FindBy(id = "CardCode")
    private WebElement cardCvv;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(Constants.CHECKOUT_PATH);
    }

    public void fillBillingAddress(String firstName, String lastName, String email,
                                   String country, String city, String address,
                                   String zip, String phone) {
        type(billingFirstName, firstName);
        type(billingLastName, lastName);
        type(billingEmail, email);

        Select countrySelect = new Select(billingCountry);
        countrySelect.selectByVisibleText(country);

        type(billingCity, city);
        type(billingAddress1, address);
        type(billingZip, zip);
        type(billingPhone, phone);
    }

    public void continueBilling() {
        click(billingContinueBtn);
    }

    public void continueShippingMethod() {
        click(shippingMethodContinueBtn);
    }

    public void selectCashOnDelivery() {
        click(cashOnDeliveryRadio);
    }

    public void selectCreditCard() {
        click(creditCardRadio);
    }

    public void continuePaymentMethod() {
        click(paymentMethodContinueBtn);
    }

    public void fillCreditCardDetails(String holder, String number, String month, String year, String cvv) {
        type(cardHolderName, holder);
        type(cardNumber, number);

        new Select(expireMonth).selectByVisibleText(month);
        new Select(expireYear).selectByVisibleText(year);

        type(cardCvv, cvv);
    }

    public void continuePaymentInfo() {
        click(paymentInfoContinueBtn);
    }

    public void confirmOrder() {
        click(confirmOrderBtn);
    }

    public boolean isOrderConfirmed() {
        return isDisplayed(orderConfirmationTitle);
    }

    public String getOrderNumber() {
        return getText(orderNumber);
    }

    public String getConfirmationMessage() {
        return getText(orderConfirmationTitle);
    }
}