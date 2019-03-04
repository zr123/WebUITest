require 'watir'
require "test/unit"
 
class TestGUI < Test::Unit::TestCase
 
  def testMinimalWikipedia
    browser = Watir::Browser.new :chrome
    browser.driver.manage.timeouts.implicit_wait = 5
    browser.goto 'https://google.com'
    browser.input(name: "q").send_keys("Wikipedia")
    browser.form(id: "tsf").submit
    browser.element(text: "Wikipedia").click
    assert_equal("Wikipedia", browser.title)
    browser.quit
  end
end
