require 'watir'

browser = Watir::Browser.new :ie
browser.goto 'https://www.google.com/'
sleep 1
browser.element(name: "q").set("bundesbank")
sleep 1
browser.send_keys :enter
sleep 1
browser.element(xpath: "//h3[text()='Deutsche Bundesbank: Startseite']").click
sleep 1
browser.close