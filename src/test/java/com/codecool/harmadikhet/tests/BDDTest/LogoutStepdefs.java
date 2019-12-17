package com.codecool.harmadikhet.tests.BDDTest;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogInPage;
import com.codecool.harmadikhet.pages.LogoutConfirmationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutStepdefs extends BaseStepdefs {

    @Given("^A logged in valid Jira account$")
    public void setUpEnvVariablesAndObjects() {
        initObjectsForBDD();
        LogInPage logInPage = baseTest.getLogInPage();
        logInPage.logIn(baseTest.getUsername(), baseTest.getPassword());
    }

    @When("^I click on the profile picture in the top right corner and choose the LogOut option$")
    public void clickOnLogoutOption() {
        HomePage homePage = new HomePage(baseTest.getDriver());
        homePage.logout();
    }

    @Then("^The \"You are now logged out. Any automatic login has also been stopped.\" text appears$")
    public void checkIfTheLogoutWasSuccessful() {
        LogoutConfirmationPage logoutConfirmationPage = new LogoutConfirmationPage(baseTest.getDriver());
        assertTrue(logoutConfirmationPage.isLogoutConfirmed());
    }

    @And("^I close the browser$")
    public void closeBrowser() {
        baseTest.quitDriver();
    }

}
