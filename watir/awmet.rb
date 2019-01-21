require 'watir'

browser = Watir::Browser.new :ie
browser.goto 'https://awmet-e.inet.bundesbank.de/awmet/'
sleep 1
browser.element(id: "meldung").click
sleep 1
browser.element(xpath: "//*[text()='Suchparameter']").click
sleep 1
browser.element(id: "inputMeldenummerTechnik").set("42")
sleep 1
browser.send_keys :enter
sleep 1
fail unless browser.text.include? '7929'
fail unless browser.text.include? 'DIKAP - Meldung steht für das Kopieren nach DIKAP bereit'
browser.close