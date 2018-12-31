package com.david.corp.web.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends PageBase {

    public InboxPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//")
    private WebElement pageHeader;

    public WebElement getPageHeader() {
        return pageHeader;
    }

    @FindBy(css = "[data-test-folder-name=Inbox]")
    private WebElement inbox;

    @FindBy(css = "[for=ybarDialpadMenu]")
    private WebElement menu;

    //this locator is not human-generated, find new one?
    @FindBy(xpath = "(//*[@id='ybarDialpadMenuBody']//*[@aria-label='Yahoo Home']/span)[1]")
    private WebElement yahooHome;

    @FindBy(css = "[title='Unread - Click to see unread mails']")
    private WebElement unread;

    @FindBy(css = "[role=presentation]")
    private WebElement profile;


    public WebElement getInbox() {
        return inbox;
    }

    public WebElement getMenu() {
        return menu;
    }

    public WebElement getYahooHome() {
        return yahooHome;
    }

    public WebElement getUnread() {
        return unread;
    }
}
