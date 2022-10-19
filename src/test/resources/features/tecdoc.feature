Feature: Handling TecDoc

  Scenario: Register an email to the TecDoc
    Given Page is opened
    When User clicks on the 'register' button
    Then User populates mandatory fields having the country set to
      |Country    |
      |Romania    |
    And User checks the registration is successful

  Scenario: Checking the email is registered
    Given Page is opened
    And User clicks on the 'Sign in' button
    And User enters Credentials to LogIn
      | Username                    | Password    |
      | karenaweimann694@gmail.com | carmen321$  |
    Then User checks if the email is registered

  Scenario: Order the TecDoc
    Given Page is opened
    And User clicks on the 'Sign in' button
    And User enters Credentials to LogIn
      | Username                     | Password    |
      | karenaweimann694@gmail.com  | carmen321$  |
    And User is ordering the TecDoc
    And User checks ordering is successful

  Scenario: Check the TecDoc licence
    Given Page is opened
    And User clicks on the 'Sign in' button
    And User enters Credentials to LogIn
      | Username                     | Password    |
      | karenaweimann694@gmail.com  | carmen321$  |
    And User clicks on the 'My web licenses' tab
    Then User is retrieving the TecDoc licence