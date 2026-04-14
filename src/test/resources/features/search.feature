Feature: Amazon Search Functionality

Scenario Outline: Search multiple products
  Given User is on Amazon homepage
  When User searches for "<product>"
  Then User should see search results related to "<product>"

Examples:
  | product |
  | iPhone  |
  | laptop  |
  | shoes   |
