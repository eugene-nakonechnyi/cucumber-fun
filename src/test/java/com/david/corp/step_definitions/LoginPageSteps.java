package com.david.corp.step_definitions;

import com.david.corp.web.pages.LoginPage;
import com.google.common.base.Function;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;


import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPageSteps implements En {

    private static final Logger logger = LogManager.getLogger();

    private WebDriverFactory driverFactory;
    private WebDriver driver;

    private LoginPage loginPage;

    public LoginPageSteps() {

        Given("^User navigates with ([^\"]*) to login page$", (String browser) -> {
            driverFactory = new WebDriverFactory();
            driver = driverFactory.getDriver(browser, "http://mail.yahoo.com");
            loginPage = new LoginPage(driver);



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


    }

}