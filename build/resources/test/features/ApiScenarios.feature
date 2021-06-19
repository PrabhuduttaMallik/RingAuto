@authAPIValidation

  Feature: Validation Authentication of User

    @auth001
    Scenario: Register a new user
      Given Register an invalidUser with "null" email "null" password and "null" username and validate the response
      Given Register an validUser with "alpha@beta.com" email "alpha1234" password and "betaUser" username and validate the response

    @getTheListOfArticles
    Scenario: Get the list of all the articles
      Given Validate the list of "articles" present with 500 articlecount

    @getListOfArticleByAuthor
    Scenario: Get the list of article by the author
      Given Get the list of articles with the uername "johnjacob"

    @getArticleByTag
    Scenario: Get the details of article by tagName
      Given Get the article details by "dragons" tag
      Given Get the article details by "Gandhi" tag
      Given Get the article details by "BlackLivesMatter" tag


    @getAllTheTags
    Scenario: Get all the tags and validate
      Given I make a get call on all the tags and validate tags




