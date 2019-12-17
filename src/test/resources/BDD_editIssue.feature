Feature: Edit an existing issue in Jira

  Scenario: Edit an existing issue successfully
    Given Logged in with a valid Jira account, and an editable issue's details page is opened in the browser
    When I click on the Edit button, and write "edited summary" to the Summary field and click the Update button
    Then I see the issue with the Summary I just entered in the previous step, and I close the browser