package com.gumtree.googlesearch.utilityclasses;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebUtilityFunctions {



    public static void enterTextInTextBox(WebDriver driver, By locator, String textToEnter){
        WebElement textBoxElement = fluentWaitForAnElement(driver, locator);
        textBoxElement.sendKeys(textToEnter);
    }

    public static void clickButtonOrLink(WebDriver driver, By locator){
        WebElement linkOrButtonElement = fluentWaitForAnElement(driver, locator);
        linkOrButtonElement.click();
    }

    public static List<WebElement> findElements(WebDriver driver, By locator){
        List<WebElement> elementsToReturn = new ArrayList<>();
        elementsToReturn = driver.findElements(locator);
        return elementsToReturn;
    }

    public static WebElement explicityWaitForElementToBeClickable(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public static WebElement fluentWaitForAnElement(WebDriver driver, final By locator){

        Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            WebElement elementToReturn = null;
            WebElement element = null;
            public WebElement apply(WebDriver driver) {
                try {
                    element  = driver.findElement(locator);

                }catch (Exception e){
                    e.printStackTrace();
                }
                if (element.isDisplayed() && element != null) {
                    elementToReturn = element;
                    return elementToReturn;
                }
                return elementToReturn;
            }
        };

        wait.until(function);

        return function.apply(driver);
    }
}
