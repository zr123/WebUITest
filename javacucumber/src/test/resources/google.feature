# language: en
@run
Feature: google

  Scenario: User can search bundesbank
    Given that I am on "https://www.google.de/"
    When I insert "Wikipedia" and press enter
    And I click the link with the text "Wikipedia"
    Then then I will be on the website with the title "Wikipedia"
