Feature: Verify Gumtree links in google search for cars in london
As a user of google
I should be able to search for cars in london
And validate search results from gumtree



Scenario: Validate gumtree links in google search results
Given I have launced google search page
When I search for "cars in london"
Then I get search results
And I validate all the gumtree links on the page

