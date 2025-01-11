package StepDefinitions;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import com.aventstack.extentreports.Status;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SortProductsPage;

public class SortProductsStep {
    private SortProductsPage sortProductsPage;

    public SortProductsStep() {
        this.sortProductsPage = new SortProductsPage(TestBase.getDriver());
    }

    @Given("the user is on the products page")
    public void userIsOnProductsPage() {
        try {
            TestBase.getDriver().get("https://www.saucedemo.com/inventory.html");
            Hooks._scenario.log(Status.PASS, "The user is on the products page");
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user is on the products page");
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @When("the user sorts products by {string}")
    public void userSortsProductsBy(String criteria) {
        try {
            sortProductsPage.sortProductsBy(criteria);
            Hooks._scenario.log(Status.PASS, "The user sorts products by: " + criteria);
        } catch (Exception e) {
            Hooks._scenario.log(Status.FAIL, "The user sorts products by: " + criteria);
            Hooks._scenario.log(Status.FAIL, e.getMessage());
        }
    }

    @Then("the products should be sorted by price in ascending order")
    public void productsShouldBeSortedByPriceAscending() {
        try {
            List<Double> prices = sortProductsPage.getProductPrices();
            for (int i = 0; i < prices.size() - 1; i++) {
                Assertions.assertTrue(prices.get(i) <= prices.get(i + 1), 
                    "Products are not sorted by price in ascending order");
            }
            Hooks._scenario.log(Status.PASS, "The products are sorted by price in ascending order");
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The products should be sorted by price in ascending order");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }

    @Then("the products should be sorted by name in descending order")
    public void productsShouldBeSortedByNameDescending() {
        try {
            List<String> names = sortProductsPage.getProductNames();
            for (int i = 0; i < names.size() - 1; i++) {
                Assertions.assertTrue(names.get(i).compareToIgnoreCase(names.get(i + 1)) >= 0, 
                    "Products are not sorted by name in descending order");
            }
            Hooks._scenario.log(Status.PASS, "The products are sorted by name in descending order");
        } catch (Throwable t) {
            Hooks._scenario.log(Status.FAIL, "The products should be sorted by name in descending order");
            Hooks._scenario.log(Status.FAIL, t.getMessage());
            throw t;
        }
    }
}
