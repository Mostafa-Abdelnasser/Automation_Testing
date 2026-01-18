# ============================================================================
# Feature: Promotions and Coupons
# Description: Tests for coupon/discount functionality on nopCommerce
# Author: Mostafa QC
# Tags: @coupon, @promotions, @regression, @negative
# ============================================================================

@coupon @promotions
Feature: Promotions and Coupons
  As a customer
  I want to apply discount coupons
  So that I can get discounts on my purchases

  # --------------------------------------------------------------------------
  # Background: User must have items in cart to apply coupon
  # --------------------------------------------------------------------------
  Background:
    Given the user has a product in the cart
    And the user is on the cart page

  # --------------------------------------------------------------------------
  # Positive Scenarios
  # --------------------------------------------------------------------------

  @regression @TC016
  Scenario: Apply valid coupon successfully
  """
    Verify that user can apply a valid coupon and discount is applied.
    Priority: High | Severity: Major
    """
    When the user enters coupon code "SAVE10"
    And the user clicks apply coupon button
    Then the coupon should be applied successfully
    And the cart total should reflect the discount

  @regression
  Scenario: Remove applied coupon
  """
    Verify that user can remove an applied coupon.
    Priority: Medium | Severity: Minor
    """
    Given the user has applied coupon "SAVE10"
    When the user removes the coupon
    Then the coupon should be removed
    And the cart total should return to original price

  # --------------------------------------------------------------------------
  # Negative Scenarios
  # --------------------------------------------------------------------------

  @regression @negative @TC017
  Scenario: Apply expired coupon fails
  """
    Verify that applying an expired coupon shows error message.
    Priority: Low | Severity: Minor
    """
    When the user enters coupon code "EXPIRED2023"
    And the user clicks apply coupon button
    Then the user should see coupon error message "coupon is expired"

  @regression @negative
  Scenario: Apply invalid coupon code fails
  """
    Verify that applying non-existent coupon shows error message.
    Priority: Low | Severity: Minor
    """
    When the user enters coupon code "INVALIDCODE123"
    And the user clicks apply coupon button
    Then the user should see coupon error message "coupon code is invalid"

  @regression @negative
  Scenario: Apply coupon with minimum order not met
  """
    Verify that coupon fails when minimum order amount is not met.
    Priority: Low | Severity: Minor
    """
    When the user enters coupon code "MIN100"
    And the user clicks apply coupon button
    Then the user should see coupon error message "minimum order"