@filterTags

Feature: Filter Page By Tags


  @filterTags001
  Scenario: Filter the page by tags
    Given I validate "Global Feed" text on the web page
    Then I wait for "HuManIty" tag details to appear on the page
    Then I click on "HuManIty" tag on the page
    Then I validate count of "HuManIty" text on the web page is not less than 10 times
    Then I click on "Gandhi" tag on the page
    Then I wait for "Gandhi" tag details to appear on the page
    Then I validate count of "Gandhi" text on the web page is not less than 10 times
    Then I click on "dragons" tag on the page
    Then I wait for "dragons" tag details to appear on the page
    Then I validate count of "dragons" text on the web page is not less than 10 times