package com.david.corp.step_definitions;

import com.david.corp.web.pages.InboxPage;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class InboxPageSteps implements En {

    private static final Logger logger = LogManager.getLogger();

    private WebDriverFactory driverFactory;
    private WebDriver driver;

    private InboxPage inboxPage;

    public InboxPageSteps() {


    }
}