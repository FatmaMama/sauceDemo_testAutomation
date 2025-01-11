package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    
    public CheckoutPage(WebDriver driver) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null");
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    public void openCartPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    
    public void clickCheckoutButton() {
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        checkoutButton.click();
    }

   
    public void enterFirstName(String firstName) {
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstNameInput.sendKeys(firstName);
    }

    
    public void enterLastName(String lastName) {
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        lastNameInput.sendKeys(lastName);
    }

   
    public void enterZipCode(String zipCode) {
        WebElement zipCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
        zipCodeInput.sendKeys(zipCode);
    }

    
    public void clickContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        continueButton.click();
    }

    
    public String getCheckoutOverviewUrl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_summary_container")));
        return driver.getCurrentUrl();
    }

   
    public void clickFinishButton() {
        WebElement finishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        finishButton.click();
    }

   
    public String getOrderConfirmationMessage() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
        return confirmationMessage.getText();
    }

    public String getCheckoutErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container")));
        return errorMessage.getText();
    }
}
