package StepDefinitions;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.loginPage;
import com.aventstack.extentreports.Status;


public class LoginStep {

    private loginPage loginPage;

    public LoginStep() {
        this.loginPage = new loginPage(TestBase.getDriver());
    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        try {
            loginPage.openLoginPage();
            Hooks._scenario.log(Status.PASS, "the user is on the login page");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "the user is on the login page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
           
        }
    }

    @When("the user enters a username as {string}")
    public void userEntersUsername(String username) {
        try {
            loginPage.enterUsername(username);
            Hooks._scenario.log(Status.PASS, "the user enters a username");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "the user enters a username" );
            Hooks._scenario.log(Status.FAIL,e.getMessage());
        }
    }

    @When("the user enters a password as {string}")
    public void userEntersPassword(String password) {
        try {
            loginPage.enterPassword(password);
            Hooks._scenario.log(Status.PASS, "the user enters a password");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "the user enters a password" );
            Hooks._scenario.log(Status.FAIL,  e.getMessage());
        }
    }

    @When("clicks on the login button")
    public void userClicksLoginButton() {
        try {
            loginPage.submitLogin();
            Hooks._scenario.log(Status.PASS, "clicks on the login button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "clicks on the login button");
            Hooks._scenario.log(Status.FAIL,e.getMessage());
     
        }
    }

    @Then("the user should be redirected to the products page")
    public void userRedirectedToProductPage() {
        try {
            String currentUrl = TestBase.getDriver().getCurrentUrl();
            Assertions.assertTrue(currentUrl.contains("inventory.html"), 
                "Redirection to products page failed. Current URL: " + currentUrl);
            
            Hooks._scenario.log(Status.PASS, "The user was successfully redirected to the products page: " + currentUrl);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should be redirected to the products page");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t; 
        }
    }
    
    @Then("the user should see a login failure message")
    public void userSeesLoginFailureMessage() {
        try {
            String failureMessage = loginPage.getErrorMessage();
            Assertions.assertTrue(failureMessage.contains("Epic sadface: Username and password do not match any user in this service") 
            || failureMessage.contains("Epic sadface: Password is required") || failureMessage.contains("Epic sadface: Username is required"), 
                    "Expected failure message not found");
            Hooks._scenario.log(Status.PASS, "The user should see a login failure message: " + failureMessage);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should see a login failure message");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t; // Re-throw to mark the scenario as failed
        }
    }
    
}
