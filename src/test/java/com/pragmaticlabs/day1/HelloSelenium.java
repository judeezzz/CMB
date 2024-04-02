package com.pragmaticlabs.day1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSelenium {
    @Test
    public void helloSelenium(){
        //Setup web browser driver (chrome driver)
        WebDriverManager.chromedriver().setup();

        //Open a web browser(Chrome browser)
        WebDriver driver = new ChromeDriver();

        //Navigate to the login screen(Type URL https://www.saucedemo.com/v1/)
        driver.get("https://www.saucedemo.com/v1/");

        //Type username "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click the login
        driver.findElement(By.id("login-button")).click();


        //Verify/check the label in the login page
        Assert.assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Products");

        //Close the browser
        driver.quit();

    }


}
