package com.pragmaticlabs.day2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class InvalidUserCredentialsTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        //Setup web browser driver (chrome driver)
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        //Open a web browser(Chrome browser)
        driver = new ChromeDriver();

        //Navigate to the login screen(Type URL https://www.saucedemo.com/v1/)
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterMethod
    public void afterMethod(){
        //Close the browser
        driver.quit();
    }

    @Test
    public void wrongUsernameWrongPassword(){
        driver.findElement(By.id("user-name")).sendKeys("abc");
        driver.findElement(By.id("password")).sendKeys("cde");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void wrongUsernameCorrectPassword(){
        driver.findElement(By.id("user-name")).sendKeys("abc");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");
        }

    @Test
    public void correctUsernameWrongPassword(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("cde");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void EmptyUsername(){
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("cde");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Username is required");
    }

    @Test
    public void EmptyPassword(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Password is required");
    }

    @Test
    public void EmptyUsernameEmptyPassword(){
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(),"Epic sadface: Username is required");
    }




}
