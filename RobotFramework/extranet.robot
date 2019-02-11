*** Settings ***
Suite Setup         Open Browser        https://extranet-t.bundesbank.de/ams/amsa/      ${BROWSER}
Suite Teardown      Close Browser
Library             SeleniumLibrary

*** Variables ***     
${BROWSER}          chrome
${DELAY}            1

*** Test Cases ***
Der Benutzer kann sich mit validen Credentials einloggen
    Set Selenium Speed          ${DELAY}
    Input Text                  username                                        ${USER}
    Input Text                  password                                        ${password}
    Click Button                Anmelden
    
Der User kann eine bestimmte Meldung filtern
    Select Frame                navi_bar
    Click link                  meldungen.meldekonto
    Unselect Frame
    Select Frame                content
    Select From List By Label   selVordruckTyp                                  Z11
    Input Text                  txtMeldetermin                                  10.2015
    Select From List By Label   selArt                                          Meldung
    Select From List By Label   selStatus                                       Versendet
    Click Button                btnFiltern
    Page Should Contain         Einen Eintrag gefunden.

Der User kann sich ausloggen
    Unselect Frame
    Select Frame                navi_subhead
    Click Link                  Abmelden