require 'watir'

browser = Watir::Browser.new :chrome
browser.goto 'https://de.wikipedia.org'
browser.link(text: "Zufälliger Artikel").click
browser.close
