package org.Testleaf;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class NegativeLoginTest {
    public static void main(String[] args) {
        // 1. Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 2. Add wait (10 sec timeout)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 3. Locate and fill username (valid)
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );
        usernameField.sendKeys("Admin");

        // 4. Locate and fill password (INTENTIONALLY WRONG!)
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("password"))
        );
        passwordField.sendKeys("wrongpassword123");

        // 5. Click the Login button
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.tagName("button"))
        );
        loginBtn.click();

        // 6. Wait for the error message to appear
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(@class, 'oxd-alert-content-text')]")
                )
        );

        // 7. Check if the error message is displayed
        if (errorMessage.isDisplayed()) {
            System.out.println("Negative test passed: Invalid credentials message shown.");
        } else {
            System.out.println("Negative test failed: Error message NOT shown.");
        }

        // 8. Close the browser
        driver.quit();
    }
}
