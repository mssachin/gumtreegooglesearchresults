package com.gumtree.googlesearch.pageobjects;

import com.gumtree.googlesearch.utilityclasses.WebUtilityFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class GoogleHomepage {

    private WebDriver driver;
    private static final By searchBoxLocator = By.id("lst-ib");
    private static final By searchButtonLocator = By.name("btnK");
    private static final By searchButtonWithinAutoComplete = By.className("lsb");


    public GoogleHomepage(WebDriver driver) {
        this.driver = driver;
    }

    public  GoogleSearchResultsPage enterKeyWordAndSearch(String keyword){
        WebUtilityFunctions.enterTextInTextBox(driver, searchBoxLocator, keyword);
        try {
            WebUtilityFunctions.clickButtonOrLink(driver, searchButtonLocator);
        }catch (WebDriverException wde){
            WebUtilityFunctions.clickButtonOrLink(driver, searchButtonWithinAutoComplete);
        }

        return new GoogleSearchResultsPage(driver);
    }

}
