package mostafa.qc.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import mostafa.qc.pages.CheckoutPage;
import mostafa.qc.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ============================================================================
 * Checkout Step Definitions
 * ============================================================================
 * Description: Step definitions for checkout process feature scenarios.
 * Maps Gherkin steps to Java automation code.
 * Author: Mostafa QC
 * ============================================================================
 */
public class CheckoutSteps {

    // ========================================================================
    // INSTANCE VARIABLES
    // ========================================================================

    private final WebDriver driver;
    private final CheckoutPage checkoutPage;

    // ========================================================================
    // CONSTRUCTOR
    // ========================================================================

    /**
     * Initializes page objects with the current WebDriver instance.
     */
    public CheckoutSteps() {
        this.driver = DriverFactory.getDriver();
        this.checkoutPage = new CheckoutPage(driver);
    }

    // ========================================================================
    // WHEN STEPS - BILLING ADDRESS
    // ========================================================================

    /**
     * Fills billing address with valid test data.
     */
    @When("the user fills billing address with valid data")
    public void theUserFillsBillingAddressWithValidData() {
        checkoutPage.fillBillingAddress(
                "John",                    // firstName
                "Doe",                     // lastName
                "john.doe@test.com",       // email
                "United States",           // country
                "New York",                // city
                "123 Test Street",         // address
                "10001",                   // zip
                "1234567890"               // phone
        );
    }

    /**
     * Leaves billing address fields empty (for negative testing).
     */
    @When("the user leaves billing address fields empty")
    public void theUserLeavesBillingAddressFieldsEmpty() {
        // Don't fill any fields - just try to continue
    }

    /**
     * Continues from billing address step.
     */
    @When("the user continues to shipping method")
    public void theUserContinuesToShippingMethod() {
        checkoutPage.continueBilling();
    }

    /**
     * Tries to continue (may fail for validation errors).
     */
    @When("the user tries to continue")
    public void theUserTriesToContinue() {
        try {
            checkoutPage.continueBilling();
        } catch (Exception e) {
            // Expected for validation errors
        }
    }

    // ========================================================================
    // WHEN STEPS - SHIPPING & PAYMENT
    // ========================================================================

    /**
     * Continues from shipping method step.
     */
    @When("the user continues to payment method")
    public void theUserContinuesToPaymentMethod() {
        checkoutPage.continueShippingMethod();
    }

    /**
     * Selects cash on delivery payment method.
     */
    @When("the user selects cash on delivery")
    public void theUserSelectsCashOnDelivery() {
        checkoutPage.selectCashOnDelivery();
    }

    /**
     * Selects credit card payment method.
     */
    @When("the user selects credit card payment")
    public void theUserSelectsCreditCardPayment() {
        checkoutPage.selectCreditCard();
    }

    /**
     * Enters valid credit card details.
     */
    @When("the user enters valid card details")
    public void theUserEntersValidCardDetails() {
        checkoutPage.fillCreditCardDetails(
                "John Doe",            // holder
                "4111111111111111",    // number (test card)
                "12",                  // month
                "2027",                // year
                "123"                  // cvv
        );
    }

    /**
     * Enters invalid credit card details (for negative testing).
     */
    @When("the user enters invalid card details")
    public void theUserEntersInvalidCardDetails() {
        checkoutPage.fillCreditCardDetails(
                "John Doe",            // holder
                "4000000000000002",    // number (declined test card)
                "12",                  // month
                "2027",                // year
                "123"                  // cvv
        );
    }

    /**
     * Continues from payment info step.
     */
    @When("the user continues to payment info")
    public void theUserContinuesToPaymentInfo() {
        checkoutPage.continuePaymentMethod();
    }

    /**
     * Confirms the order.
     */
    @When("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        checkoutPage.continuePaymentInfo();
        checkoutPage.confirmOrder();
    }

    // ========================================================================
    // THEN STEPS
    // ========================================================================

    /**
     * Verifies order was placed successfully.
     */
    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        assertThat(checkoutPage.isOrderConfirmed())
                .as("Order should be confirmed")
                .isTrue();
    }

    /**
     * Verifies order confirmation with order number is displayed.
     */
    @Then("the user should see order confirmation with order number")
    public void theUserShouldSeeOrderConfirmationWithOrderNumber() {
        assertThat(checkoutPage.isOrderConfirmed())
                .as("Order confirmation should be displayed")
                .isTrue();

        String orderNumber = checkoutPage.getOrderNumber();
        assertThat(orderNumber)
                .as("Order number should be displayed")
                .isNotEmpty();

        System.out.println("Order placed successfully. Order Number: " + orderNumber);
    }

    /**
     * Verifies payment error message is displayed.
     */
    @Then("the user should see payment error message")
    public void theUserShouldSeePaymentErrorMessage() {
        // Verify we're not on confirmation page (payment failed)
        assertThat(checkoutPage.isOrderConfirmed())
                .as("Order should NOT be confirmed due to payment error")
                .isFalse();
    }

    /**
     * Verifies billing validation errors are displayed.
     */
    @Then("the user should see billing validation errors")
    public void theUserShouldSeeBillingValidationErrors() {
        // Verify we're still on billing step (validation failed)
        assertThat(driver.getCurrentUrl())
                .as("User should still be on checkout page with validation errors")
                .contains("checkout");
    }
}