package com.david.corp.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static RemoteWebDriver driver;


    RemoteWebDriver getDriver(String browser, String url) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        if (browser.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

            caps.setCapability("browserName", "Chrome");
            caps.setCapability("version", "67x64");
            caps.setCapability("platform", "Windows 10");

            driver = new ChromeDriver();
        }

        if (browser.equals("firefox")) {

            System.setProperty("webdriver.firefox.driver", "drivers/chromedriver");

            caps.setCapability("browserName", "Firefox");
            caps.setCapability("version", "61x64");
            caps.setCapability("platform", "Windows 10");

            driver = new FirefoxDriver();
        }

        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.get(url);

        return driver;
    }


    @Before
    public void beforeSteps(Scenario scenario) {

        if (driver != null) {

            driver.quit();

        }

    }


    @After
    public void tearDown(Scenario scenario) {

        if (driver != null) {

            driver.quit();

        }

    }


}