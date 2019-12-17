package com.codecool.harmadikhet.tests.BDDTest;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepdefs extends BaseStepdefs {

    @Given("^A valid Jira account$")
    public void setUpEnvVariablesAndObjects() {
        initObjectsForBDD();
    }

    @When("^I have a valid Jira account and I navigate to the login page of Jira and log in$")
    public void openTheLoginJiraPageAndEnterValidCredentials() {
        LogInPage logInPage = baseTest.getLogInPage();
        logInPage.logIn(baseTest.getUsername(), baseTest.getPassword());
    }

    @Then("^The profile picture appears and the logout option is available$")
    public void checkProfilePictureAndLogoutOption() {
        HomePage homePage = new HomePage(baseTest.getDriver());
        homePage.clickUserIcon();
        assertTrue(homePage.isUserIconDisplayed());
        assertTrue(homePage.isLogoutOptionDisplayed());
        baseTest.quitDriver();
    }

}
