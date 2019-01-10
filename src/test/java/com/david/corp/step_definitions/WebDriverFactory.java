package com.david.corp.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static RemoteWebDriver driver;

    RemoteWebDriver getDriver(String browser, String url) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        if (browser.equals("chrome")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");

            driver = new RemoteWebDriver(new URL("http://" + ReadPropertiesFile.getProperty("grid.ip") + ":4444/wd/hub"), capabilities);

//            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//
//            caps.setCapability("browserName", "Chrome");
//            caps.setCapability("version", "67x64");
//            caps.setCapability("platform", "Windows 10");
//
//            driver = new ChromeDriver();
        }

        if (browser.equals("firefox")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL("http://" + ReadPropertiesFile.getProperty("grid.ip") + ":4444/wd/hub"), capabilities);

//            System.setProperty("webdriver.firefox.marionette", "drivers/geckodriver.exe");
//
//            caps.setCapability("browserName", "Firefox");
//            caps.setCapability("version", "61x64");
//            caps.setCapability("platform", "Windows 10");
//
//            driver = new FirefoxDriver();
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
