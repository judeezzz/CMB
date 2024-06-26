package com.pragmaticlabs.day2.crossbrowser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EdgeTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        //Setup web browser driver (edge driver)
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        //Open a web browser(Chrome browser)
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod(){
        //Close the browser
        driver.quit();
    }


    @Test
    public void helloSelenium(){

        //Navigate to the login screen(Type URL https://www.saucedemo.com/v1/)
        driver.get("https://www.saucedemo.com/v1/");

        //Type username "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click the login
        driver.findElement(By.id("login-button")).click();


        //Verify/check the label in the login page
        //Assert.assertEquals(driver.findElement(By.cssSelector("span.title")).getText(),"Products");


    }


}
