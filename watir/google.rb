require 'watir'

browser = Watir::Browser.new :chrome
browser.goto 'https://www.google.com/'
sleep 1
browser.element(name: "q").send_keys("bundesbank")
browser.send_keys :enter
sleep 1
browser.element(xpath: "//h3[text()='Deutsche Bundesbank: Startseite']").click
sleep 1
browser.close