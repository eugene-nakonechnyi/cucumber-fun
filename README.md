# cucumber-fun

This project intended to help David to dove in the beautiful world of UI automation

## How to run tests

As a fiers step you have to download chrome and firefox drivers.
In project rood should be created folder "drivers" and downloaded drivers should be placed there. Do not forget to enable driver execution permitions(like: $ chmod +x chromedriver).

## We will split our course in three logical parts, and will learn them in the way how FE tests design process goes.

Every test should starts with acceptance creteria decomposition. A soon as we have acceptance criteria we are ready to start with feature files. To desigh feature file we have to know [gherkin](https://docs.cucumber.io/gherkin/).

Current framework based on popular "Page Object" model. Following this approach new test design starts with the new page description in a separate class. Page class contains locators for all of required elements and getters for them.
Let's have a look on how to [locate](https://www.testingexcellence.com/how-to-locate-web-elements-in-webdriver/) elements on page using webdriver.
[XPath](https://www.w3schools.com/xml/xpath_syntax.asp) and [Css](https://www.testingexcellence.com/css-selectors-selenium-webdriver/) selectors are powerful and flexible as they can be used to locate any element on a page.

So, the first task:
- let's create an yahoo email account 
- let's create a feature file with successful login test(LoginUITest.feature).
- let's create a new page object class LoginPage.java and describe yahoo email login [page](https://login.yahoo.com) in it.
- lets create a new page object class InboxPage.java and describe inbox email page in it.

## Let's not waiting for dead men's shoes.

So, proper waiting is a whole universe. We can't write complicated scenario without waits for different conditions like some page were loaded or some element appears. Lets have a look on all of available waits in [WebDriver](https://www.testingexcellence.com/webdriver-explicit-implicit-fluent-wait/). And lets have a look on possible [expected contitions](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html) for custom waits.

So, now we should do the next:
- lets implement wait method to handle new page opening.
- lets implement wait method to handle new tab opening.
- lets implement wait method to handle new folder opening.
