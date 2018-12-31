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

/*        And("^User enters username: \"([^\"]*)\"$", (String username) -> {
            loginPage.getXLoginFieldAutocapitalize().sendKeys(username);
        });*/

        And("^User enters username: ([^\"]*)$", (String username) -> {
            loginPage.getLoginField().sendKeys(username);
        });

        When ("^User clicks Next$", () -> {
            loginPage.nextButton.click();
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
        Then("^Inbox is displayed$", () -> {
            inboxPage.getInbox().isDisplayed();

        });
        When("^User clicks Unread$", () -> {
            //explicit wait
            WebElement dynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Unread - Click to see unread mails']")));
            inboxPage.getUnread().click();
            //hint: waits can be defined for the whole class, or for all the steps
            //or a helper method
        });
        When("^User clicks top right menu$", () -> {

            inboxPage.getMenu().click();
        });
        Then("^User can click Yahoo link$", () -> {
            //fluent wait
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(5, SECONDS)
                    .pollingEvery(2,SECONDS)
                    .ignoring(NoSuchElementException.class);
            WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
                public WebElement apply(WebDriver driver){
                    return driver.findElement(By.xpath("(//*[@id='ybarDialpadMenuBody']//*[@aria-label='Yahoo Home']/span)[1]"));
                    //possible to-do: find a cleaner thing to find, ie url, title
                }
            });

            //save the web handle first
            String currentTab = driver.getWindowHandle();

            inboxPage.getYahooHome().click();

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //implement new until condition
            WebElement yahooHome = wait.until(new Function<WebDriver, WebElement>(){
                public WebElement apply(WebDriver driver){
                    return driver.findElement(By.cssSelector("[title='Search Web']"));
                }
            });

            driver.switchTo().window(currentTab);

            Thread.sleep(5000);

        });

        //new tab steps
        When("^User opens new tab$", () -> {
//            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
//
//            Actions act = new Actions(driver);
            //sendKeys is the error here
//            act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();

            String SelectLinkNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            driver.findElement(By.xpath("//span[@class='_yb_1uf1n _yb_f2om4']"));

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            driver.switchTo().window(tabs.get(0));
        });
        Then("^New tab is displayed$", () -> {
            driver.getCurrentUrl().compareTo("https://www.google.com");
        });

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
    //to-do cleanup: replace the waiting methods with the helper method
}