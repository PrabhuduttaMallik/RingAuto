# RingAuto

Framework Details
Technologies Used
1.Language - Java
2.Framework - Gherkin & Cucumber
3.Build Tool - Gradle (Version - 4.10.2)
4.Reporting - Cucumber Reporting
5.WebAutomation Tool - Selenium 4 6.API Automation Tool - RestAssured

Package Details
Actions - Responsible for all the operation that will take place on the page.
Pages - Contains all the webelement for the page which selenium will interact.
Steps - Responsible for all the test flows to happen when automation will be triggered.
Utils - Contains Utility which will be used by Action class to perform operation.
Hooks - Used to launch and close browser along with generating report after the automation run is completed.
APIHooks - initialize and read the property details and loads the base URL.
Feature - Contains all the test case in form of Cucumber steps.
testData - Contains all the type of data we want to test and on which environment to perform the testing.

Automation Flow
Hooks-> Launch Browser-> Get the URL to open -> pick the feature step to run -> Navigate to Steps class which contain the method for the step -> Navigate to Action class -> From Action class Perform operation -> End of the Test close Browser -> generate Cucumber Report.

The build.gradle file contains 2 task methods which are basically trigger to run UI and API automation scenarios.

UI Run Command
gradle -Dorg.gradle.project.testTags=@filterTags001 -Dorg.gradle.project.envType=prod -Dorg.gradle.project.browser=chrome :UIAssignment

API RUN COMMAND gradle -Dorg.gradle.project.testTags=@getTheListOfArticles -Dorg.gradle.project.envType=qaAPI :APIAssignment
