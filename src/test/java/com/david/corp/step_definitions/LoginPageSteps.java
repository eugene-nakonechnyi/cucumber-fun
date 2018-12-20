package com.david.corp.step_definitions;

import com.david.corp.web.pages.MainPage;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps implements En {

    private static final Logger logger = LogManager.getLogger();

    private WebDriverFactory driverFactory;
    private WebDriver driver;

    private MainPage mainPage;

    public LoginPageSteps() {

        Given("^User navigates with \"([^\"]*)\" to login page$", (String browser) -> {

            driverFactory = new WebDriverFactory();

            driver = driverFactory.getDriver(browser, "http://www.google.com");

            mainPage = new MainPage(driver);

        });

    }
}
