Feature: Amazon Cart Functionality

Scenario: Add product to cart
  Given User is on Amazon homepage
  When User searches for "Mouse"
  And User selects first product
  And User adds product to cart
  Then Product should be added to cart