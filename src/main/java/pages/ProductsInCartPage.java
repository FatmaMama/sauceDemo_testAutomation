package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsInCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    
    public ProductsInCartPage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    public void addProductToCart(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-" + productId)));
        addToCartButton.click();
    }

    public void removeProductFromCart(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-" + productId)));
        removeButton.click();
    }
    
    // public void AddNonExistentProduct(String productName) {
    //     try {
    //         String productId = productName.toLowerCase().replace(" ", "-");
    //         WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-" + productId)));
    //         addToCartButton.click();
    //     } catch (Exception e) {
    //         throw new RuntimeException("Product not found: " + productName);
    //     }
    // }

   
    public int getCartItemCount() {
        WebElement cartItemCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        return Integer.parseInt(cartItemCount.getText());
    }

   
    // public String getAddProductErrorMessage() {
    //     WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container")));
    //     return errorMessage.getText();
    // }
    
}
