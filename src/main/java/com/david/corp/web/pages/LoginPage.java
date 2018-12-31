package com.david.corp.web.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//")
    private WebElement pageHeader;

    public WebElement getPageHeader() {
        return pageHeader;
    }

    //find by id

    //Login Field
    @FindBy (name = "username")
    private WebElement loginField;

    //Next button
    @FindBy (id = "login-signin")
    public WebElement nextButton;

    //Password field
    @FindBy (id = "login-passwd")
    public WebElement passwordField;

    //Sign in button
    @FindBy (id = "login-signin")
    public WebElement signInButton;




    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginField() {
        return loginField;
    }

}
