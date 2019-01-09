package com.david.corp.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends PageBase {

    public AccountPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='li-activity ']")
    private WebElement recentActivity;

    @FindBy(css = "[class='action-item-row tdevice-item']")
    private List<WebElement> deviceList;

//    @FindBy(css = "[class='tdevices-history-list']")
//    private List<WebElement> historyList;

    @FindBy(css = "[class='last-use']")
    private List<WebElement> lastUseDate;

    @FindBy(css = "[class='close']")
    private WebElement activityCloseButton;


    public WebElement getRecentActivity() {
        return recentActivity;
    }

    public List<WebElement> getDeviceList() {
        return deviceList;
    }

//    public List<WebElement> getHistoryList() {
//        return historyList;
//    }

    public List<WebElement> getLastUseDate() {
        return lastUseDate;
    }

    public WebElement getActivityCloseButton() {
        return activityCloseButton;
    }
}
