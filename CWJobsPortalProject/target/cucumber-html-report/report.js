$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AdvancedJobSearch.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "CWJob search with advanced filters and keywords",
  "description": "",
  "id": "cwjob-search-with-advanced-filters-and-keywords",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6652100853,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Navigate to homepage and verify job types and job listed",
  "description": "",
  "id": "cwjob-search-with-advanced-filters-and-keywords;navigate-to-homepage-and-verify-job-types-and-job-listed",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@All"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "user on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "user select job type",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "display permanent \"Permanent\"",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "display companies have job ads listed",
  "keyword": "And "
});
formatter.match({
  "location": "CWJobsHomeSteps.user_on_home_page()"
});
formatter.result({
  "duration": 6064687548,
  "status": "passed"
});
formatter.match({
  "location": "CWJobsHomeSteps.user_select_job_type()"
});
formatter.result({
  "duration": 112845747,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Permanent",
      "offset": 19
    }
  ],
  "location": "CWJobsHomeSteps.display_permanent(String)"
});
formatter.result({
  "duration": 508463641,
  "status": "passed"
});
formatter.match({
  "location": "CWJobsHomeSteps.display_companies_have_job_ads_listed()"
});
formatter.result({
  "duration": 45011129,
  "status": "passed"
});
formatter.after({
  "duration": 1100537371,
  "status": "passed"
});
formatter.before({
  "duration": 5630791185,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Job search with advanced filters",
  "description": "",
  "id": "cwjob-search-with-advanced-filters-and-keywords;job-search-with-advanced-filters",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 29,
      "name": "@All"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "user on home page",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "user select job type \"Permanent\"",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "select recruiter type \"Employer\" in location \"Manchester\"",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "select salary \"Annual\" of at least \"£20,000.00\" for the keyword \"Manager\"",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "verify at least 2 pages of jobs returned",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "verify the result page html source contains \"APPMEASUREMENT CODE\"",
  "keyword": "And "
});
formatter.match({
  "location": "CWJobsHomeSteps.user_on_home_page()"
});
formatter.result({
  "duration": 6557035167,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Permanent",
      "offset": 22
    }
  ],
  "location": "CWJobsHomeSteps.user_select_job_type(String)"
});
formatter.result({
  "duration": 541413177,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Employer",
      "offset": 23
    },
    {
      "val": "Manchester",
      "offset": 46
    }
  ],
  "location": "CWJobsHomeSteps.select_recruiter_type_in_location(String,String)"
});
formatter.result({
  "duration": 470588236,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Annual",
      "offset": 15
    },
    {
      "val": "£20,000.00",
      "offset": 36
    },
    {
      "val": "Manager",
      "offset": 65
    }
  ],
  "location": "CWJobsHomeSteps.with_salary_of_at_least_for_the_keyword(String,String,String)"
});
formatter.result({
  "duration": 3557864153,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 16
    }
  ],
  "location": "CWJobsHomeSteps.verify_at_least_pages_of_jobs_returned(int)"
});
formatter.result({
  "duration": 116484518,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "APPMEASUREMENT CODE",
      "offset": 45
    }
  ],
  "location": "CWJobsHomeSteps.verify_the_result_page_html_source_contains(String)"
});
formatter.result({
  "duration": 43036862,
  "status": "passed"
});
formatter.after({
  "duration": 1257609113,
  "status": "passed"
});
});