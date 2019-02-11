# language: en
@run
Feature: google

  Scenario: User can search bundesbank
    Given that i am on "https://www.google.de/"
    When i enter bundesbank and press enter
    Then the first result will be the website of bundesbank

  Scenario: User can Click Random Article
  	Given that i am on "https://de.wikipedia.org"
  	Then i can click "Zufälliger Artikel"
