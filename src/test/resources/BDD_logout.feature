Feature: Successful logout from Jira

  Scenario: Log out from Jira successfully
    Given A logged in valid Jira account
    When I click on the profile picture in the top right corner and choose the LogOut option
    Then The "You are now logged out. Any automatic login has also been stopped." text appears