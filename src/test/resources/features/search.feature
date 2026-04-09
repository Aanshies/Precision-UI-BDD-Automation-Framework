Feature: Amazon Search Functionality

  Scenario: Search for iPhone
    Given User is on Amazon homepage
    When User searches for "iPhone"
    Then User should see search results related to "iPhone"
