$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ApiScenarios.feature");
formatter.feature({
  "line": 3,
  "name": "Validation Authentication of User",
  "description": "",
  "id": "validation-authentication-of-user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@authAPIValidation"
    }
  ]
});
formatter.before({
  "duration": 626500,
  "status": "passed"
});
formatter.before({
  "duration": 16380300,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Get all the tags and validate",
  "description": "",
  "id": "validation-authentication-of-user;get-all-the-tags-and-validate",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@getAllTheTags"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "I make a get call on all the tags and validate tags",
  "keyword": "Given "
});
formatter.match({
  "location": "APISteps.getAllTags()"
});
formatter.result({
  "duration": 25356656900,
  "status": "passed"
});
formatter.after({
  "duration": 269400,
  "status": "passed"
});
formatter.after({
  "duration": 45800,
  "status": "passed"
});
});