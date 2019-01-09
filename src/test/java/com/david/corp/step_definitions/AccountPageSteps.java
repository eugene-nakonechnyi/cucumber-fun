package com.david.corp.step_definitions;

import com.david.corp.web.pages.LoginPage;
import cucumber.api.java8.En;

import com.david.corp.web.pages.InboxPage;
import com.david.corp.web.pages.AccountPage;
import org.openqa.selenium.*;
import org.testng.Assert;


import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

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

            driver.manage().timeouts().implicitlyWait(30, SECONDS);

            loginPage.login(username, password);
        });

        When("^User clicks Account info tab in inbox page$", () -> {

            inboxPage.getAccountMenu().click();
            inboxPage.getAccountInfo().get(0).click();

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));


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
            int result = 0;
            for(int i=0; i < accountPage.getLastUseDate().size(); i++){
                if (accountPage.getLastUseDate().get(i).getText().equals(creationDate)){
                    result = i;
                    break;
                }
            }

            Assert.assertEquals(accountPage.getLastUseDate().get(result).getText(), creationDate);
        });
    }
}
