*** Settings ***
Library     SeleniumLibrary

*** Test Cases ***
Mein Beispieltest: Zufälligen Artikel bei Wikipedia klicken
    Open Browser        https://de.wikipedia.org        ie
    Set Selenium Speed  1
    Click Link          Zufälliger Artikel
    [Teardown]          Close Browser
