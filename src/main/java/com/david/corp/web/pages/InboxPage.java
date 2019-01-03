package com.david.corp.web.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    //1
//    @FindBy(css = "[data-test-id='message-subject'][1]")
//    @FindBy(xpath = "(//*[@data-test-id='senders'])[0]")
//    @FindBy(xpath = "//button[@data-test-id='icon-btn-checkbox']")
//    @FindBy(xpath = "//a[@href='/d/folders/1/messages/4']")
    @FindBy(css = "[data-test-id=senders]")
    private List<WebElement> emails;

    //2
//    @FindBy(css = "[title='Archive - no emails  ']")
//    @FindBy(xpath = "//a[@href='/d/folders/21']")
    @FindBy(css = "span[data-test-folder-name=Archive]")
    private WebElement archive;



    @FindBy(css = "[data-test-id='undo-button']")
    private WebElement undoButton;

//    //3
//    @FindBy(css = "([data-test-id='message-subject'])[-1]")
//    private WebElement lastEmail;


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

    public List<WebElement> getEmails() {
        return emails;
    }

    public WebElement getArchive() { return archive; }

    public WebElement getUndoButton() { return undoButton; }


}
