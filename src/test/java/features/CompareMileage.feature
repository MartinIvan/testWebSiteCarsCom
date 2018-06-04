Feature: Compare mileages
  As a user
  I want to compare mileages of two cars

  Scenario: Compare two auto

    Given I search two auto and add to compare

    When I go to compare

    Then I compare mileages in compare page and page auto