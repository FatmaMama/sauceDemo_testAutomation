package StepDefinitions;

import org.junit.jupiter.api.Assertions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsInCartPage;

public class RemoveProductStep {
    private ProductsInCartPage productsInCartPage;

    public RemoveProductStep() {
        this.productsInCartPage = new ProductsInCartPage(TestBase.getDriver());
    }


    @When("the user removes the first product {string} from the cart")
    public void userRemovesProductFromCart(String productName) {
        try {
            productsInCartPage.removeProductFromCart(productName);
            Hooks._scenario.log(Status.PASS, "The user removes the product: " + productName);
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user removes the product: " + productName);
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @Then("the cart should display {int} item")
    public void cartShouldDisplayItems(int expectedItemCount) {
        try {
            int actualItemCount = productsInCartPage.getCartItemCount();
            Assertions.assertEquals(expectedItemCount, actualItemCount, 
                "Cart item count is incorrect. Expected: " + expectedItemCount + ", Actual: " + actualItemCount);
            Hooks._scenario.log(Status.PASS, "The cart displays " + actualItemCount + " items");
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The cart should display " + expectedItemCount + " items");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }
}
