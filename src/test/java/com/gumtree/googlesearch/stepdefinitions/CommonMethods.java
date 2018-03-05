package com.gumtree.googlesearch.stepdefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

     private TestBase testBase;
     private WebDriver driver;


    public CommonMethods(TestBase testBase) {
        this.testBase = testBase;
        driver = testBase.getDriver();

    }

    @Given("^I have launced google search page$")
    public void i_have_launced_google_search_page() throws Throwable {
        driver.navigate().to("https://google.co.uk");

    }
}
