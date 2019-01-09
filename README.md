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

## Nothing is impossible to a willing heart

Sometimes we cannot use native webdriver methods because of special styling(disabled UI elements). [JavaScript executor](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html) can be used in such cases.

Let's try the next:
- let's implement click method using javascript.
- let's implement input text value method using javascript.

## Composite actions

Complex user gestures can be emulated using [Actions](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html) WebDriver class.

Let's try next:
- let's move any email to any folder using drag and drop.
- let's do a context click on any email.
- let's move mouse to last email.

## Cucumber feature tags

[Tags](https://docs.cucumber.io/cucumber/api/#tags) are a great way to organise your features and scenarios.

- let's create test runner class to run tests with specific tags
- let's create test runner class to run all of tests

## Well now we have everything to rock

- let's create happy path test for new email compose
- let's create delete email test
- let's create tests for email list toolbar (archive, move, spam ...)
- let's create new folder create test

## Let's try to create a new test including feature file, step definitions, page objects. 

Following User menu > Account Info > Recent Activity you can find login activity for the last 30 days. You have to scroll this list to bottom and click on the first item in the list, the login activity list will be popped up. First login activity date can be treated as account creation date(Wed, Dec 26, 2018 12:55 PM PST).

- Let's create a new test to validate account creation date(can be validated in recent activities)
