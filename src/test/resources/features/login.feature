Feature: SauceDemo Application

  Scenario: Scenario 1 - Valid Login
    Given User is on SauceDemo login page
    When User enters valid username and password
    And User clicks login button
    Then User should be on products page
    And Products should be displayed

  Scenario: Scenario 2 - Add product to cart and validate
    Given User is on SauceDemo login page
    When User enters valid username and password
    And User clicks login button
    Then User should be on products page

    When User selects a product
    And User adds product to cart
    Then Cart count should be 1

    When User opens cart
    Then Correct product should be displayed in cart
    And Product price should be correct
    
  Scenario: Scenario 3 - Login using JSON data
  Given User is on SauceDemo login page
  When User enters credentials for "standard_user"
  And User clicks login button
  Then User should be on products page