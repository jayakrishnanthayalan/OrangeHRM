package org.Testleaf;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class NegativeLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Test steps
            driver.get("https://opensource-demo.orangehrmlive.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("wrongpassword123");
            driver.findElement(By.tagName("button")).click();

            // Verification
            WebElement errorMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(@class, 'oxd-alert-content-text')]")
                    )
            );
            System.out.println(errorMessage.isDisplayed()
                    ? "Negative test passed: Invalid credentials message shown."
                    : "Negative test failed: Error message NOT shown.");

        } finally {
            driver.quit();
        }
    }
}