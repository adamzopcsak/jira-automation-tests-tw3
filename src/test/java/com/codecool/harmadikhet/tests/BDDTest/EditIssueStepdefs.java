package com.codecool.harmadikhet.tests.BDDTest;

import com.codecool.harmadikhet.pages.IssueDetailsPage;
import com.codecool.harmadikhet.pages.IssueEditModalPage;
import com.codecool.harmadikhet.pages.LogInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditIssueStepdefs extends BaseStepdefs {

    private IssueDetailsPage issueDetailsPage;
    private IssueEditModalPage issueEditModalPage;

    @Given("^Logged in with a valid Jira account, and an editable issue's details page is opened in the browser$")
    public void setUpEnvVariablesAndObjects() {
        initObjectsForBDD();
        LogInPage logInPage = baseTest.getLogInPage();
        logInPage.logIn(baseTest.getUsername(), baseTest.getPassword());
        issueDetailsPage = new IssueDetailsPage(baseTest.getDriver());
        issueDetailsPage.navigateToIssueDetailPage("/projects/MTP/issues/MTP-899");
    }

    @When("^I click on the Edit button, and write \"edited summary\" to the Summary field and click the Update button$")
    public void editIssue() {
        issueDetailsPage.editGivenIssue();
        issueEditModalPage = new IssueEditModalPage(baseTest.getDriver());
        issueEditModalPage.editIssue("edited summary");
        issueEditModalPage.acceptEdit();
    }

    @Then("^I see the issue's summary has changed to \"edited summary\"$")
    public void checkEditedSummary() {
        assertEquals(issueDetailsPage.getEditedIssueSummary(), "edited summary");
    }

    @And("I reset the test data and quit the browser")
    public void resetTestDataAndCloseBrowser() {
        issueDetailsPage.editGivenIssue();
        issueEditModalPage.editIssue("summary");
        issueEditModalPage.acceptEdit();
        baseTest.quitDriver();
    }
}
