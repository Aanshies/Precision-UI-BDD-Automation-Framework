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


# Feature: Amazon Search Functionality
#
# Scenario: Search for iPhone
#   Given User is on Amazon homepage
#   When User searches for "iPhone"
#   Then User should see search results related to "iPhone"
