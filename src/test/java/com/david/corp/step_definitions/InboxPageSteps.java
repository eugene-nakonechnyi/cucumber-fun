package com.david.corp.step_definitions;

import com.david.corp.web.pages.InboxPage;
import com.david.corp.web.pages.LoginPage;
import com.david.corp.web.pages.AccountPage;
import com.google.common.base.Function;
import cucumber.api.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.SECONDS;

public class InboxPageSteps implements En {

    private static final Logger logger = LogManager.getLogger();

    private WebDriverFactory driverFactory;
    private WebDriver driver;

    private LoginPage loginPage;
    private InboxPage inboxPage;
    private AccountPage accountPage;

    public InboxPageSteps() {

        //Login step
        Given("^User navigates with ([^\"]*) to login page with username: ([^\"]*) and password: ([^\"]*)$", (String browser, String username, String password) -> {
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

        When("^User clicks Unread at inbox page$", () -> {
            //explicit wait
            WebElement dynamicElement = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-smartview-type='UNREAD']")));
            inboxPage.getUnread().click();
        });
        When("^User clicks top right menu at inbox page$", () -> {

            inboxPage.getMenu().click();
        });
        Then("^User can click Yahoo link at inbox page$", () -> {
            //fluent wait
            this.untilConditionXPath("(//*[@id='ybarDialpadMenuBody']//*[@aria-label='Yahoo Home']/span)[1]");

            String currentTab = driver.getWindowHandle();

            inboxPage.getYahooHome().click();

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            this.untilConditionCSS("[title='Search Web']");

            driver.switchTo().window(currentTab);

            Thread.sleep(5000);

        });

        //new tab steps
        When("^User opens new tab at inbox page$", () -> {
            String SelectLinkNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            driver.findElement(By.xpath("//span[@class='_yb_1uf1n _yb_f2om4']"));

            ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            driver.switchTo().window(tabs.get(0));
        });
        Then("^New tab is displayed at inbox page$", () -> {
            driver.getCurrentUrl().compareTo("https://www.google.com");
        });


        //Actions steps

        When("^User drags an email to archive at inbox page$", () -> {
            inboxPage.dragDropJavaScript(inboxPage.getEmails().get(0), inboxPage.getArchive());
            Thread.sleep(5000);
        });
        And("^User can click undo button at inbox page$", () -> {
            inboxPage.getUndoButton().click();
        });
        Then("^User can open an an email at inbox page$", () -> {
            Actions act = new Actions(driver);
            act.contextClick(inboxPage.getEmails().get(0)).perform();
            Thread.sleep(2000);
        });

        Then("^User can open last email at inbox page$", () -> {
            Actions act = new Actions(driver);
//            this.createAction(driver);
            int arrayLastIndex = inboxPage.getEmails().size() - 1;
            act.contextClick(inboxPage.getEmails().get(arrayLastIndex)).perform();
            Thread.sleep(2000);
        });
        When("^User clicks compose button$", () -> {
            inboxPage.getComposeButton().click();
        });
        Then("^User can input an ([^\"]*)$", (String address) -> {
            Actions actions = new Actions(driver);
            actions.moveToElement(inboxPage.getEmailToField());
            actions.click();
            actions.sendKeys(address);
            actions.sendKeys(Keys.RETURN);
            actions.build().perform();
            Thread.sleep(5000);

//            inboxPage.getEmailToField().sendKeys(address);
//            inboxPage.getEmailSubject().sendKeys(subject);
//            inboxPage.getEmailBody().sendKeys(body);

        });
        And("^User can input a ([^\"]*)$", (String subject) -> {
            inboxPage.getEmailSubject().sendKeys("Test Subject Evaluation");
//            Actions actions = new Actions(driver);
//            actions.moveToElement(inboxPage.getEmailSubject());
//            actions.click();
//            actions.sendKeys(subject);
//            actions.build().perform();
        });

        And("^User can write a ([^\"]*)$", (String body) -> {
            Actions actions = new Actions(driver);
            actions.moveToElement(inboxPage.getEmailBody());
            actions.click();
            actions.sendKeys(body);
            actions.build().perform();
        });

        And("^User can click send button$", () -> {
            inboxPage.getSendButton().click();
        });
        Then("^Email is displayed in Sent folder ([^\"]*)$", (String body) -> {
            inboxPage.getSentFolder().click();
            inboxPage.getEmails().get(0).click();
            //is there a way to compare against the body string from two steps ago?
            inboxPage.getMessageBody().toString().compareTo(body);
        });

        Then("^User can delete the email$", () -> {
            Thread.sleep(10000);
            inboxPage.getInbox().click();
            inboxPage.getEmails().get(0).click();
            this.untilConditionCSS("[data-test-id='toolbar-delete']");
            inboxPage.getDeleteButton().click();
        });
        When("^User clicks create custom folder$", () -> {
            inboxPage.getCreateNewFolder().click();
        });
        Then("^New can enter ([^\"]*)$", (String folderName) -> {
            inboxPage.getNewFolderName().sendKeys(folderName);
            inboxPage.getNewFolderName().sendKeys(Keys.RETURN);

        });
        And("^New folder is created$", () -> {
            inboxPage.getCustomFolder().click();
        });
        Then("^User can use archive on the email$", () -> {
            inboxPage.getEmails().get(0).click();
            inboxPage.getArchiveButton().click();
        });
        Then("^User can use move on the email$", () -> {
            inboxPage.getEmails().get(0).click();
            inboxPage.getMoveButton().click();
            inboxPage.getToTrash().click();
        });
        Then("^User can use spam on the email$", () -> {
            inboxPage.getEmails().get(0).click();
            inboxPage.getSpamButton().click();
        });
//        Then("^User can delete ([^\"]*)$", () -> {
//            Actions actions = new Actions(driver);
//            actions.moveToElement(inboxPage.getCustomFolder());
//            actions.moveToElement(inboxPage.getFolderOptions());
//            actions.click();
//            actions.moveToElement(inboxPage.getDeleteFolder());
//            actions.click();
//            actions.build().perform();
//        });

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

    private void untilConditionXPath (String elementLocator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(2,SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement yahooHome = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath(elementLocator));
            }
        });

    }
}