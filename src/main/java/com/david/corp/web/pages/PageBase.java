package com.david.corp.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBase {

        private static final Logger logger = LogManager.getLogger();
        protected final WebDriver driver;

        public PageBase(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }

        public void waitTillPageHasBeenFullyLoaded() {
            ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(pageLoadCondition);
            logger.info("Page Loaded...");
        }

        protected WebElement waitWebElementToBeVisible(WebElement element) {
            return (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(element));
        }

        protected List<WebElement> waitListWebElementsToBeVisible(List<WebElement> elements) {

            return (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.visibilityOfAllElements(elements));
        }

        protected WebElement waitWebElementToBeClicable(WebElement element) {

            return (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(element));
        }

        /**
         * Returns true if element is visible
         *
         * @param element WebElement
         * @return Boolean expression true | false
         */
        protected Boolean isElementVisible(WebElement element) {
            return element.isDisplayed();
        }

        /**
         * Populates passed value to input.
         *
         * @param element WebElement which have to be populated
         * @param value   String desired value
         */
        public void setValueUsingJs(WebElement element, String value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

        /**
         * Does a click on hidden elements.
         *
         * @param element WebElement which have to be clicked
         */
        public void clickElementUsingJs(WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

}
