# cucumber-fun

This project intended to help David to dove in the beautiful world of UI automation

## How to run tests

As a fiers step you have to download chrome and firefox drivers.
In project rood should be created folder "drivers" and downloaded drivers should be placed there. Do not forget to enable driver execution permitions(like: $ chmod +x chromedriver).

## We will split our course in three logical parts, and will learn them in the way how FE tests design process goes.

Current framework based on popular "Page Object" model. Following this approach new test design starts with the new page description in a separate class. Page class contains locators for all of required elements and getters for them.
Let's have a look on how to [locate]https://www.w3schools.com/cssref/css_selectors.asp) elements on page using webdriver.
[XPath](https://www.w3schools.com/xml/xpath_syntax.asp) and [Css](https://www.testingexcellence.com/css-selectors-selenium-webdriver/) selectors are powerful and flexible as they can be used to locate any element on a page.
So, the first task:
- let's create an yahoo email account 
- let's create a new page object class LoginPage.java and describe yahoo email login [page](https://login.yahoo.com) in it.
- lets create a new page object class InboxPage.java and describe inbox email page in it.
