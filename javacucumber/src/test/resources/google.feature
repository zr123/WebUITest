@run
Feature: google

  Scenario: User can search bundesbank
    Given that i am on "https://www.google.de/"
    When i enter bundesbank and press enter
    Then the first result will be the website of bundesbank
