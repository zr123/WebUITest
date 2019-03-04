require 'selenium-webdriver'
require "test/unit"
 
class TestGUI < Test::Unit::TestCase
 
  def testMinimalWikipedia
    driver = Selenium::WebDriver.for :chrome
    driver.get('https://google.com')
    driver.manage.timeouts.implicit_wait = 5
    element = driver.find_element(name: 'q')
    element.send_keys("Wikipedia")
    element.submit
    driver.find_element(xpath: "//h3[text()='Wikipedia']").click
    assert_equal("Wikipedia", driver.title)
    driver.quit
  end
 
end
