package com.gumtree.googlesearch.pageobjects;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gumtree.googlesearch.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchResultsPage {

    private WebDriver driver;
    private static final By linkLocator = By.partialLinkText("- Gumtree");

    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<String> navigateToGumtreeLinksOnOnSearchResultsPageAndCaptureTitles(){
        String resultsURL = driver.getCurrentUrl();
        List<String> gumTreePageTitles = new ArrayList<>();
        int initialSize =1;
        int initialIndex =0;
        for(int i=0; i<initialSize; i++){
            List<WebElement> gumtreeLinkElements = WebUtilityFunctions.findElements(driver, linkLocator);
            initialSize = gumtreeLinkElements.size();
            WebElement linkElement = gumtreeLinkElements.get(initialIndex);
            driver.navigate().to(linkElement.getAttribute("href"));
            String pageTitle = driver.getTitle();
            gumTreePageTitles.add(pageTitle);
            initialIndex++;
            driver.navigate().to(resultsURL);
        }


         return gumTreePageTitles;

    }

}
