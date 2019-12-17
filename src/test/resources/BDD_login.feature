Feature: Jira login feature

  Scenario: Log in to Jira successfully
    Given A valid Jira account
    When I have a valid Jira account and I navigate to the login page of Jira and log in
    Then The profile picture appears and the logout option is available