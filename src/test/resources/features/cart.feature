Feature: Amazon Cart Functionality

Scenario: Add product to cart
  Given User is on Amazon homepage
  When User searches for "Mouse"
  Then User should see search results related to "Mouse"
  When User selects first product
  Then User adds product to cart
  And Product should be added to cart