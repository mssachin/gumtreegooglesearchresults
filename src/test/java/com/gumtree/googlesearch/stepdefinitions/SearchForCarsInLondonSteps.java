package com.gumtree.googlesearch.stepdefinitions;

import com.gumtree.googlesearch.pageobjects.GoogleHomepage;
import com.gumtree.googlesearch.pageobjects.GoogleSearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchForCarsInLondonSteps {

    private TestBase testBase;
    private WebDriver driver;
    private GoogleHomepage googleHomepage;
    private GoogleSearchResultsPage googleSearchResultsPage;
    private List<String> gumTreePageTitles = new ArrayList<>();



    public SearchForCarsInLondonSteps(TestBase testBase) {
        this.testBase = testBase;
        driver = testBase.getDriver();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String keyWord) throws Throwable {
       googleHomepage = new GoogleHomepage(driver);
       googleSearchResultsPage= googleHomepage.enterKeyWordAndSearch(keyWord);

    }

    @Then("^I get search results$")
    public void i_get_search_results() throws Throwable {
        gumTreePageTitles =googleSearchResultsPage.navigateToGumtreeLinksOnOnSearchResultsPageAndCaptureTitles();
    }

    @And("^I validate all the gumtree links on the page$")
    public void i_validate_all_the_gumtree_links_on_the_page() throws Throwable {

        Assert.assertTrue(gumTreePageTitles.size()>0);
        for(String titles: gumTreePageTitles){
         String text = titles;
         System.out.println(" Title Text is "+text);
         Assert.assertTrue(text.contains("- Gumtree"));
        }
    }
}
