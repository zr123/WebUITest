*** Settings ***
Library           SeleniumLibrary

*** Variables ***
${SERVER}         https://awmet-e.inet.bundesbank.de/awmet/
${BROWSER}        chrome
${DELAY}          1

*** Test Cases ***
User can filter Meldenummer
	Open Browser				${SERVER}								${BROWSER}
	Maximize Browser Window
	Set Selenium Speed			${DELAY}
	Click Element				meldung
	Click Element				xpath://*[text()='Suchparameter']
	Input Text					inputMeldenummerTechnik					42
	Press Keys					inputMeldenummerTechnik					ENTER
	Page Should Contain			7929
	Page Should Contain			DIKAP - Meldung steht für das Kopieren nach DIKAP bereit
	[Teardown] 					Close Browser