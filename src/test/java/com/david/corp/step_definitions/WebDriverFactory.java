package com.david.corp.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

        private static RemoteWebDriver driver;


        RemoteWebDriver getDriver(String browser, String url) throws MalformedURLException {

            String needVideo = System.getProperty("video", "false");
            String recordNetwork = System.getProperty("network", "false");

            if (!browser.equals("local")) {

                DesiredCapabilities caps = new DesiredCapabilities();

                if (browser.equals("chrome")) {

                    caps.setCapability("browserName", "Chrome");
                    caps.setCapability("version", "67x64");
                    caps.setCapability("platform", "Windows 10");

                }

                if (browser.equals("firefox")) {

                    caps.setCapability("browserName", "Firefox");
                    caps.setCapability("version", "61x64");
                    caps.setCapability("platform", "Windows 10");

                }

                if (browser.equals("safari")) {

                    caps.setCapability("browserName", "Safari");
                    caps.setCapability("version", "11");
                    caps.setCapability("platform", "Mac OSX 10.13");

                }

                if (browser.equals("ie")) {

                    caps.setCapability("browserName", "Internet Explorer");
                    caps.setCapability("version", "11");
                    caps.setCapability("platform", "Windows 10");
                    caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

                }

            } else {

                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();

            }

            driver.manage().window().maximize();

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
