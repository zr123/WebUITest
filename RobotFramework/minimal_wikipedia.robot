*** Settings ***
Library     SeleniumLibrary

*** Test Cases ***
Mein Beispieltest: Bei Google nach Wikipedia gucken
    Open Browser                    https://www.google.com/             ie
    Set Selenium Implicit Wait      5
    Input Text                      q                                   wikipedia
    Submit Form
    Click Element                   xpath://h3[text()='Wikipedia']
    Title Should Be                 Wikipedia
    [Teardown]                      Close Browser
