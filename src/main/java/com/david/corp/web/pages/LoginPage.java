package com.david.corp.web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    //======================= LOGIN HELPER =====================

    public void login(String username, String password){
        ((JavascriptExecutor) driver).executeScript(
                "var username = document.getElementById('login-username');\n" +
                        "username.value = arguments[0]", username);

        ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('login-signin').click()");

        getPasswordField().sendKeys(password);

        signInButton.click();

        waitWebElementToBeVisible(driver.findElement(By.cssSelector("div#mail-app-container")));
    }

}
