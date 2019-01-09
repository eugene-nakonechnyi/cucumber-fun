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

//    @FindBy(css = "[data-test-id='message-subject'][1]")
//    @FindBy(xpath = "(//*[@data-test-id='senders'])[0]")
//    @FindBy(xpath = "//button[@data-test-id='icon-btn-checkbox']")
//    @FindBy(xpath = "//a[@href='/d/folders/1/messages/4']")
    @FindBy(css = "[data-test-id=senders]")
    private List<WebElement> emails;

//    @FindBy(css = "[title='Archive - no emails  ']")
//    @FindBy(xpath = "//a[@href='/d/folders/21']")
    @FindBy(css = "span[data-test-folder-name=Archive]")
    private WebElement archive;

    @FindBy(css = "[data-test-id='undo-button']")
    private WebElement undoButton;

    @FindBy(css = "[data-test-id='compose-button']")
    private WebElement composeButton;

    @FindBy(css = "[data-test-id='compose-header-field-to']")
    private WebElement emailToField;

    @FindBy(css = "[data-test-id='compose-subject']")
    private WebElement emailSubject;

    @FindBy(css = "[data-test-id='rte']")
    private WebElement emailBody;

    @FindBy(css = "[data-test-id='compose-send-button']")
    private WebElement sendButton;

    @FindBy(css ="span[data-test-folder-name='Sent']")
    private WebElement sentFolder;

    @FindBy(css = "[data-test-id='toolbar-delete']")
    private WebElement deleteButton;

    @FindBy(css = "[data-test-id='message-view-body-content']")
    private WebElement messageBody;

    @FindBy(css = "[data-test-id='create-folder-container']")
    private WebElement createNewFolder;

    @FindBy(css = "[aria-label='Enter folder name [Press enter to create folder]']")
    private WebElement newFolderName;

    @FindBy(css = "[data-test-folder-name='TestFolder']")
    private WebElement customFolder;

    @FindBy(css = "[data-test-id='folder-menu-hook']")
    private WebElement folderOptions;

    @FindBy(css = "[title='Delete folder']")
    private WebElement deleteFolder;

    @FindBy(css = "[data-test-id='toolbar-archive']")
    private WebElement archiveButton;

    @FindBy(css = "[data-test-id='folder-menu-button']")
    private WebElement moveButton;

    @FindBy(css = "[title='Trash']")
    private WebElement toTrash;

    @FindBy(css = "[data-test-id='toolbar-spam']")
    private WebElement spamButton;

    @FindBy (css = "[for='ybarAccountMenu']")
    private WebElement accountMenu;

    @FindBy (xpath = "//a[contains(@href, 'https://login.yahoo.com/account/personalinfo')]")
    private List<WebElement> accountInfo;


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

    public WebElement getProfile() {
        return profile;
    }

    public WebElement getComposeButton() {
        return composeButton;
    }

    public WebElement getEmailToField() {
        return emailToField;
    }

    public WebElement getEmailSubject() {
        return emailSubject;
    }

    public WebElement getEmailBody() {
        return emailBody;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getSentFolder() {
        return sentFolder;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getMessageBody() {
        return messageBody;
    }

    public WebElement getCreateNewFolder() {
        return createNewFolder;
    }

    public WebElement getNewFolderName() {
        return newFolderName;
    }

    public WebElement getCustomFolder() {
        return customFolder;
    }

    public WebElement getFolderOptions() {
        return folderOptions;
    }

    public WebElement getDeleteFolder() {
        return deleteFolder;
    }

    public WebElement getArchiveButton() {
        return archiveButton;
    }

    public WebElement getMoveButton() {
        return moveButton;
    }

    public WebElement getToTrash() {
        return toTrash;
    }

    public WebElement getSpamButton() {
        return spamButton;
    }

    public WebElement getAccountMenu() {
        return accountMenu;
    }

    public List<WebElement> getAccountInfo() {
        return accountInfo;
    }
}
