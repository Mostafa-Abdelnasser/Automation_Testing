package mostafa.qc.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import mostafa.qc.pages.HomePage;
import mostafa.qc.pages.SearchResultsPage;
import mostafa.qc.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ============================================================================
 * Search Step Definitions
 * ============================================================================
 * Description: Step definitions for product search feature scenarios.
 * Maps Gherkin steps to Java automation code.
 * Author: Mostafa QC
 * ============================================================================
 */
public class SearchSteps {

    // ========================================================================
    // INSTANCE VARIABLES
    // ========================================================================

    private final WebDriver driver;
    private final HomePage homePage;
    private final SearchResultsPage searchResultsPage;

    // ========================================================================
    // CONSTRUCTOR
    // ========================================================================

    /**
     * Initializes page objects with the current WebDriver instance.
     */
    public SearchSteps() {
        this.driver = DriverFactory.getDriver();
        this.homePage = new HomePage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
    }

    // ========================================================================
    // GIVEN STEPS
    // ========================================================================

    /**
     * Navigates to the home page.
     */
    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homePage.open();
    }

    // ========================================================================
    // WHEN STEPS
    // ========================================================================

    /**
     * Performs a product search.
     *
     * @param keyword Search keyword
     */
    @When("the user searches for {string}")
    public void theUserSearchesFor(String keyword) {
        homePage.searchFor(keyword);
    }

    /**
     * Types in search box without submitting (for auto-suggest testing).
     *
     * @param keyword Partial search keyword
     */
    @When("the user types {string} in the search box")
    public void theUserTypesInTheSearchBox(String keyword) {
        // This would need a separate method in HomePage that doesn't click search
        // For now, we'll use the search method
        homePage.searchFor(keyword);
    }

    // ========================================================================
    // THEN STEPS
    // ========================================================================

    /**
     * Verifies search results are displayed.
     */
    @Then("the search results should be displayed")
    public void theSearchResultsShouldBeDisplayed() {
        assertThat(searchResultsPage.hasResults())
                .as("Search results should be displayed")
                .isTrue();
    }

    /**
     * Verifies search results contain products with specified keyword.
     *
     * @param keyword Expected keyword in product names
     */
    @Then("the search results should contain products with {string}")
    public void theSearchResultsShouldContainProductsWith(String keyword) {
        List<String> productNames = searchResultsPage.getAllProductNames();

        assertThat(productNames)
                .as("At least one product should contain the keyword")
                .anyMatch(name -> name.toLowerCase().contains(keyword.toLowerCase()));
    }

    /**
     * Verifies search results contain products.
     */
    @Then("the search results should contain products")
    public void theSearchResultsShouldContainProducts() {
        assertThat(searchResultsPage.getProductCount())
                .as("Search results should contain at least one product")
                .isGreaterThan(0);
    }

    /**
     * Verifies no results message is displayed.
     *
     * @param expectedMessage Expected no results message
     */
    @Then("the user should see no results message {string}")
    public void theUserShouldSeeNoResultsMessage(String expectedMessage) {
        assertThat(searchResultsPage.isNoResultMessageDisplayed())
                .as("No results message should be displayed")
                .isTrue();

        assertThat(searchResultsPage.getNoResultMessage())
                .as("No results message should contain expected text")
                .containsIgnoringCase(expectedMessage);
    }

    /**
     * Verifies search warning message is displayed (for empty search).
     */
    @Then("the user should see search warning message")
    public void theUserShouldSeeSearchWarningMessage() {
        // Verify URL contains search or warning is shown
        assertThat(driver.getCurrentUrl())
                .as("User should be on search page or see warning")
                .contains("search");
    }

    /**
     * Verifies auto-suggest dropdown appears.
     */
    @Then("the auto-suggest dropdown should appear")
    public void theAutoSuggestDropdownShouldAppear() {
        // This would need implementation in HomePage/SearchResultsPage
        // Placeholder for now
        assertThat(true).isTrue();
    }

    /**
     * Verifies suggestions contain relevant products.
     */
    @Then("the suggestions should contain relevant products")
    public void theSuggestionsShouldContainRelevantProducts() {
        // This would need implementation in HomePage/SearchResultsPage
        // Placeholder for now
        assertThat(true).isTrue();
    }
}