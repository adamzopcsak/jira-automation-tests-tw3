package com.codecool.harmadikhet.tests.BDDTest;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepdefs extends BaseStepdefs {

    @Given("^A valid Jira account$")
    public void setUpEnvVariablesAndObjects() {
        initObjectsForBDD();
    }

    @When("^I navigate to the login page of Jira and log in with the valid credentials$")
    public void openTheLoginJiraPageAndEnterValidCredentials() {
        LogInPage logInPage = baseTest.getLogInPage();
        logInPage.logIn(baseTest.getUsername(), baseTest.getPassword());
    }

    @Then("^The profile picture in the top right corner and the logout option is available in the user menu$")
    public void checkProfilePictureAndLogoutOption() {
        HomePage homePage = new HomePage(baseTest.getDriver());
        homePage.clickUserIcon();
        assertTrue(homePage.isUserIconDisplayed());
        assertTrue(homePage.isLogoutOptionDisplayed());
    }

    @And("^I close the browser after validation$")
    public void closeBrowser() {
        baseTest.quitDriver();
    }

}
