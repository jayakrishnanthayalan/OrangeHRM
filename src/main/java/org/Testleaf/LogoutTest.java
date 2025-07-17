package org.Testleaf;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LogoutTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Login
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        // 2. Logout
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.oxd-userdropdown-tab"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']"))).click();

        // 3. Verification
        wait.until(ExpectedConditions.urlContains("auth/login"));
        System.out.println(driver.getCurrentUrl().contains("auth/login") ? "Logout successful" : "Logout failed");

        driver.quit();
    }
}