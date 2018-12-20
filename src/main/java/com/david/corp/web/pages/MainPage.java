package com.david.corp.web.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//")
    private WebElement pageHeader;

    public WebElement getPageHeader() {
        return pageHeader;
    }

}
