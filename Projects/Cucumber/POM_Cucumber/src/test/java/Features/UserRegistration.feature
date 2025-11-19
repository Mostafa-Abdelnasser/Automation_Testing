# feature is the first file that is made after that comes classes  test cases
  # then create step definition
  # logically we need to make TestRunners firs

  # head line
Feature: User Registration
    # description
    Check functionality of the user registration
@register
 Scenario Outline: User can Register successfully
    Given : the user in the home page
    When : user click on the register button
    And : enter "<firstname>" , "<lastname>" , "<email>" , "<password>"
    Then : user should register successfully
  Examples:
    | firstname | lastname | email         | password  |
    | ahmed     | mohamed  | lol@gmail.com | jlsdjflsf |
    | cola      | mohamed  | ol@gmail.com  | jlsdjflsf |
    | farag     | willy    | l@gmail.com   | jlsdjflsf |


