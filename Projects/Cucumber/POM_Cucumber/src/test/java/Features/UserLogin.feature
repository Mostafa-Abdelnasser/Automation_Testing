# feature is the first file that is made after that comes classes  test cases
  # then create step definition
  # logically we need to make TestRunners firs

  # head line
Feature: User Login
    # description
  Check functionality of the user login

  @login
 Scenario Outline: User can login successfully
    Given : the user at the home page
    When : user click on the Login button
    And : enter "<email>" , "<password>"
    Then : user should Login successfully
    Examples:
      | email         | password  |
      | lol@gmail.com | jlsdjflsf |
      | ol@gmail.com  | jlsdjflsf |
      | l@gmail.com   | jlsdjflsf |

    # just add more scenarios as you like
@blog
  Scenario: User open blog page from home page
    Given : the user at the home page
    When : user click on the Login button
    And : enter click on blogs
    Then : user should open blog page successfully
