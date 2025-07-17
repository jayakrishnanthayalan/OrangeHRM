package org.Testleaf;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LeafTabs
{
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");

        ChromeDriver driver = new ChromeDriver(opt);
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Id
        WebElement element = driver.findElement(By.id("username")); //30-1 29
        element.sendKeys("demo");//30-25 5
        element.clear();//30 0.1

        Thread.sleep(3000);
        element.sendKeys("demosalesmanager");//30


        // name
        driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

        // tag name
        String text = driver.findElement(By.tagName("label")).getText();

        System.out.println(text);
        // classname linkText partiala linkText tagname xpath css

        driver.findElement(By.className("decorativeSubmit")).click();

        // partialLinktext

        driver.findElement(By.partialLinkText("CR")).click();

        // linkText
        driver.findElement(By.linkText("Leads")).click();

        driver.findElement((By.linkText("Create Lead"))).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        driver.findElement(By.id("createLeadForm_companyName")).clear();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Qeagle");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jayakrishnan");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Thayalan");
        driver.findElement(By.name("submitButton")).click();

        String UN=driver.findElement(By.id("viewLead_firstName_sp")).getText();

        if(UN.contains("Jayakrishnan"))
        {
            System.out.println("verified");
        }

    }
}
