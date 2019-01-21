*** Settings ***
Library             SeleniumLibrary

*** Variables ***
${SERVER}           https://www.google.com/
${BROWSER}          ie
${DELAY}            1

*** Test Cases ***
User can search bundesbank
    Open Browser                ${SERVER}                               ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed          ${DELAY}
    Input Text                  q                                       bundesbank
    Press Keys                  None                                    ENTER
  # Click Link                  https://www.bundesbank.de/de
    Click Element               xpath://h3[text()='Deutsche Bundesbank: Startseite']
    [Teardown]                  Close Browser
    
    