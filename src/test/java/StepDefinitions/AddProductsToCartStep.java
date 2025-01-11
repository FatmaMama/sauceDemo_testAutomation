package StepDefinitions;

import org.junit.jupiter.api.Assertions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsInCartPage;

public class AddProductsToCartStep {
    private ProductsInCartPage addProductsToCartPage;

    public AddProductsToCartStep() {
        this.addProductsToCartPage = new ProductsInCartPage(TestBase.getDriver());
    }

    @When("the user adds the first product {string} to the cart")
    public void userAddsProductToCart(String product) {
        try {
            addProductsToCartPage.addProductToCart(product);
            Hooks._scenario.log(Status.PASS, "The user adds product " + product + " to the cart");
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user fails to add product " + product + " to the cart");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }

    @And("the user adds the second product {string} to the cart")
    public void userAddsSecondProductToCart(String product) {
        try {
            addProductsToCartPage.addProductToCart(product);
            Hooks._scenario.log(Status.PASS, "The user adds product " + product + " to the cart");
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The user fails to add product " + product + " to the cart");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }

    @Then("the cart should display {int} items")
    public void cartShouldDisplayItems(int expectedItemCount) {
        try {
            int actualItemCount = addProductsToCartPage.getCartItemCount();
            Assertions.assertEquals(expectedItemCount, actualItemCount, 
                "Cart item count is incorrect. Expected: " + expectedItemCount + ", Actual: " + actualItemCount);
            Hooks._scenario.log(Status.PASS, "The cart displays " + actualItemCount + " items");
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The cart should display " + expectedItemCount + " items");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }

    // @When("the user attempts to add a non-existent product {string} to the cart")
    // public void userAttemptsToAddNonExistentProduct(String productName) {
    //     try {
    //         addProductsToCartPage.AddNonExistentProduct(productName);
    //         Hooks._scenario.log(Status.PASS, "The user attempts to add a non-existent product: " + productName);
    //     } catch (Exception e) {
    //         Hooks._scenario.log(Status.FAIL, "The user attempts to add a non-existent product");
    //         Hooks._scenario.log(Status.FAIL, e.getMessage());
    //     }
    // }

    // @Then("the user should see an error message {string} when adding a product")
    // public void userSeesErrorAddMessage(String expectedErrorMessage) {
    //     try {
    //         String actualErrorMessage = addProductsToCartPage.getAddProductErrorMessage();
    //         Assertions.assertTrue(actualErrorMessage.contains(expectedErrorMessage), 
    //             "Expected error message not found. Actual message: " + actualErrorMessage);
    //         Hooks._scenario.log(Status.PASS, "The user sees the error message: " + actualErrorMessage);
    //     } catch (Throwable t) {
    //         Hooks._scenario.log(Status.FAIL, "The user should see an error message: " + expectedErrorMessage);
    //         Hooks._scenario.log(Status.FAIL, t.getMessage());
    //         throw t;
    //     }
    // }

}
