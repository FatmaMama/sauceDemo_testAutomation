package StepDefinitions;

import org.junit.jupiter.api.Assertions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutStep {

    private CheckoutPage checkoutPage;

    public CheckoutStep() {
        this.checkoutPage = new CheckoutPage(TestBase.getDriver());
    }

    @Given("the user is on the cart page")
    public void userIsOnCartPage() {
        try {
            checkoutPage.openCartPage();
            Hooks._scenario.log(Status.PASS, "The user is on the cart page");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is on the cart page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user clicks on the checkout button")
    public void userClicksCheckoutButton() {
        try {
            checkoutPage.clickCheckoutButton();
            Hooks._scenario.log(Status.PASS, "The user clicks on the checkout button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user clicks on the checkout button");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user enters the first name as {string}")
    public void userEntersFirstName(String firstName) {
        try {
            checkoutPage.enterFirstName(firstName);
            Hooks._scenario.log(Status.PASS, "The user enters the first name: " + firstName);
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user enters the first name");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user enters the last name as {string}")
    public void userEntersLastName(String lastName) {
        try {
            checkoutPage.enterLastName(lastName);
            Hooks._scenario.log(Status.PASS, "The user enters the last name: " + lastName);
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user enters the last name");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user enters the zip code as {string}")
    public void userEntersZipCode(String zipCode) {
        try {
            checkoutPage.enterZipCode(zipCode);
            Hooks._scenario.log(Status.PASS, "The user enters the zip code: " + zipCode);
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user enters the zip code");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user clicks on the continue button")
    public void userClicksContinueButton() {
        try {
            checkoutPage.clickContinueButton();
            Hooks._scenario.log(Status.PASS, "The user clicks on the continue button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user clicks on the continue button");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @Then("the user should be redirected to the checkout overview page")
    public void userRedirectedToCheckoutOverviewPage() {
        try {
            String currentUrl = checkoutPage.getCheckoutOverviewUrl();
            Assertions.assertTrue(currentUrl.contains("checkout-step-two.html"), 
                "Redirection to checkout overview page failed. Current URL: " + currentUrl);
            Hooks._scenario.log(Status.PASS, "The user is redirected to the checkout overview page: " + currentUrl);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should be redirected to the checkout overview page");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }

    @When("the user clicks on the finish button")
    public void userClicksFinishButton() {
        try {
            checkoutPage.clickFinishButton();
            Hooks._scenario.log(Status.PASS, "The user clicks on the finish button");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user clicks on the finish button");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @Then("the user should see the order confirmation message")
    public void userSeesOrderConfirmationMessage() {
        try {
            String confirmationMessage = checkoutPage.getOrderConfirmationMessage();
            Assertions.assertEquals("Thank you for your order!", confirmationMessage, 
                "Order confirmation message is incorrect");
            Hooks._scenario.log(Status.PASS, "The user sees the order confirmation message: " + confirmationMessage);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should see the order confirmation message");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }

    @Then("the user should see an error message {string}")
    public void userSeesCheckoutErrorMessage(String expectedErrorMessage) {
        try {
            String actualErrorMessage = checkoutPage.getCheckoutErrorMessage();
            Assertions.assertTrue(actualErrorMessage.contains(expectedErrorMessage), 
                "Expected error message not found. Actual message: " + actualErrorMessage);
            Hooks._scenario.log(Status.PASS, "The user sees the error message: " + actualErrorMessage);
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user should see an error message: " + expectedErrorMessage);
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }
}