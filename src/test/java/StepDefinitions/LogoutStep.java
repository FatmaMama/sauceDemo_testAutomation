package StepDefinitions;

import org.junit.jupiter.api.Assertions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;

public class LogoutStep {
    private LogoutPage logoutPage;

    public LogoutStep() {
        this.logoutPage = new LogoutPage(TestBase.getDriver());
    }

    @Given("the user opens the sidebar menu by clicking the menu button")
    public void userIsLoggedInAndOnProductsPage() {
        try {
            logoutPage.openSidebarMenu(); 
            Hooks._scenario.log(Status.PASS, "The user is logged in and on the products page");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is logged in and on the products page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user clicks on the logout button")
    public void userClicksLogoutButton() {
        try {
            logoutPage.clickLogoutButton(); 
            Hooks._scenario.log(Status.PASS, "The user clicks on the logout button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user clicks on the logout button");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @Then("the user should be redirected to the login page")
    public void userRedirectedToLoginPage() {
        try {
            String currentUrl = logoutPage.getLoginPageUrl();
            Assertions.assertTrue(currentUrl.contains("https://www.saucedemo.com/"), 
                "Redirection to login page failed. Current URL: " + currentUrl);
            Hooks._scenario.log(Status.PASS, "The user is redirected to the login page: " + currentUrl);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should be redirected to the login page");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }
}
