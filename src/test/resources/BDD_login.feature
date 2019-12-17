Feature: Jira login feature

  Scenario: Log in to Jira successfully
    Given A valid Jira account
    When I navigate to the login page of Jira and log in with the valid credentials
    Then The profile picture in the top right corner and the logout option is available in the user menu
    And I close the browser after validation