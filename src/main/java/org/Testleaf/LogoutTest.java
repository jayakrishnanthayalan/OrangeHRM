package org.Testleaf;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LogoutTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Login
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("admin123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        loginBtn.click();

        // Step 2: Wait for dashboard to load (target welcome/profile icon)
        WebElement profileDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("span.oxd-userdropdown-tab")
                )
        );
        profileDropdown.click();

        // Step 3: Click Logout option
        WebElement logoutBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[text()='Logout']")
                )
        );
        logoutBtn.click();

        // Step 4: Verify if redirected to login page
        wait.until(ExpectedConditions.urlContains("auth/login"));
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("auth/login")) {
            System.out.println("Logout successful: Redirected to login page.");
        } else {
            System.out.println("Logout failed: Still logged in.");
        }

        driver.quit();
    }
}
