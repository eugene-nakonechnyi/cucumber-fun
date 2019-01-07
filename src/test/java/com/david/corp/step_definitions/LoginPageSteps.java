package com.david.corp.step_definitions;

import com.david.corp.web.pages.LoginPage;
import com.google.common.base.Function;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//temp
import com.david.corp.web.pages.InboxPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPageSteps implements En {

    private static final Logger logger = LogManager.getLogger();

    private WebDriverFactory driverFactory;
    private WebDriver driver;

    private LoginPage loginPage;
    private InboxPage inboxPage;

    public LoginPageSteps() {

        Given("^User navigates with ([^\"]*) to login page$", (String browser) -> {
            driverFactory = new WebDriverFactory();
            driver = driverFactory.getDriver(browser, "http://mail.yahoo.com");
            loginPage = new LoginPage(driver);
            inboxPage = new InboxPage(driver);



            //implicit wait
            driver.manage().timeouts().implicitlyWait(30, SECONDS);
        });

        And("^User enters username: ([^\"]*)$", (String username) -> {
//            loginPage.getLoginField().sendKeys(username);
            ((JavascriptExecutor) driver).executeScript(
                    "var username = document.getElementById('login-username');\n" +
                            "username.value = arguments[0]", username);
        });

        When ("^User clicks Next$", () -> {
//            loginPage.nextButton.click();
            ((JavascriptExecutor) driver).executeScript(
                    "document.getElementById('login-signin').click()");
        });

        Then("^Password screen should be displayed$", () -> {
            loginPage.passwordField.isDisplayed();
        });

        And("^User enters password: ([^\"]*)$", (String password) -> {
            loginPage.getPasswordField().sendKeys(password);
        });



        And ("^User clicks sign in button", () -> {
            loginPage.signInButton.click();

        });


        And ("^Mailbox screen should be displayed", () -> {
            driver.getCurrentUrl().equals("https://mail.yahoo.com/d/folders/1");

        });



        //how to pass a webdriver?
        //Inbox steps

    }
    //=============Helpers

    /**
     * This method can be used to wait for a custom element being located on the page
     * @param elementLocator is a String representing the css locator to target
     * @return
     */
    private void untilConditionCSS (String elementLocator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(2,SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement yahooHome = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.cssSelector(elementLocator));
            }
        });

    }


//    private void createAction (WebDriver driver){
//        Actions act = new Actions(driver);
//    }
    //to-do cleanup: replace the waiting methods with the helper method
}