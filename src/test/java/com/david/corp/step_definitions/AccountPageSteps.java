package com.david.corp.step_definitions;

import com.david.corp.web.pages.LoginPage;
import cucumber.api.java8.En;

import com.david.corp.web.pages.LoginPage;
import com.david.corp.web.pages.InboxPage;
import com.david.corp.web.pages.AccountPage;
import com.google.common.base.Function;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.SECONDS;

import static java.util.concurrent.TimeUnit.SECONDS;



public class AccountPageSteps implements En {
    private WebDriverFactory driverFactory;
    private WebDriver driver;

    private LoginPage loginPage;
    private InboxPage inboxPage;
    private AccountPage accountPage;


    public AccountPageSteps() {

        Given("^Account page: User navigates with ([^\"]*) to login page with username: ([^\"]*) and password: ([^\"]*)$", (String browser, String username, String password) -> {
            driverFactory = new WebDriverFactory();
            driver = driverFactory.getDriver(browser, "http://mail.yahoo.com");
            loginPage = new LoginPage(driver);
            inboxPage = new InboxPage(driver);
            accountPage = new AccountPage(driver);

            //implicit wait
            driver.manage().timeouts().implicitlyWait(30, SECONDS);

            //Login
            loginPage.login(username, password);
        });

        When("^User clicks Account info tab in inbox page$", () -> {
//            String mailboxTab = driver.getWindowHandle();

            inboxPage.getAccountMenu().click();
            inboxPage.getAccountInfo().get(0).click();

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

//            String profileTab = driver.getWindowHandle();

        });
        And("^User clicks Recent Activity in profile page$", () -> {
            accountPage.getRecentActivity().click();
        });
        Then("^User can see account history$", () -> {
            for (int i = 0; i < accountPage.getDeviceList().size(); i++){
                accountPage.getDeviceList().get(i).click();
                if (accountPage.getLastUseDate().size() > 6){
                    break;
                }
                else{
                    accountPage.getActivityCloseButton().click();
                }
            }

        });
        And("^User can scroll to the bottom of activity list$", () -> {
            Actions act = new Actions(driver);
            act.sendKeys(Keys.PAGE_DOWN);
            act.build().perform();

        });
        And("^Earliest activity matches ([^\"]*)$", (String creationDate) -> {
            String result = "fail";
            for(int i=0; i < accountPage.getLastUseDate().size(); i++){
                String check = accountPage.getLastUseDate().get(i).getText();
                if (check.equals(creationDate)){
                    result = "pass";
                }

            }
            if (result.equals("pass")){
                System.out.println("The loop worked.");

            }
            else {
                loginPage.getLoginField().click();
                //is there a way to just return a fail state?
            }


        });
    }
}
