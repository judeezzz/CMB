package com.pragmaticlabs.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IntroductionToSyncTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testCollapseDiv() throws InterruptedException {
        driver = new ChromeDriver();
        driver.navigate().to("https://eviltester.github.io/synchole/collapseable.html");

        //driver.findElement(By.cssSelector("section.condense")).click();
        //Thread.sleep(5000); --Never use
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("a#aboutLink")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("about.html"));

    }

    @Test
    public void testWithExplicitWait() throws InterruptedException {
        driver = new ChromeDriver();
        driver.navigate().to("https://eviltester.github.io/synchole/collapseable.html");
        driver.findElement(By.cssSelector("section.condense")).click();

        driver.findElement(By.cssSelector("a#aboutLink")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(50))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#aboutLink"))).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("about.html"));

    }

}
