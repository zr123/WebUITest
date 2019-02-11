require 'selenium-webdriver'

driver = Selenium::WebDriver.for :chrome

driver.get('https://de.wikipedia.org')
#sleep 1
driver.find_element(link_text: "Zufälliger Artikel").click 
sleep 5
driver.close
