#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: CWJob search with advanced filters and keywords

@All
  Scenario:  Navigate to homepage and verify job types and job listed
    Given user on home page
    When user select job type
    Then display permanent "Permanent"
    And display companies have job ads listed

@All
  Scenario:  Job search with advanced filters
    Given user on home page
    When user select job type "Permanent"
    And select recruiter type "Employer" in location "Manchester"
    And select salary "Annual" of at least "£20,000.00" for the keyword "Manager"
    Then verify at least 2 pages of jobs returned
    And verify the result page html source contains "APPMEASUREMENT CODE"