package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day7Test5 {
    WebDriver driver;
    //In Test1 we have to verify that the page is loaded successfully
    @Test(priority = 1)
    public void testcase1() throws InterruptedException {
        //Enter user name
        WebElement user_id = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        user_id.sendKeys("Admin");

        //Enter password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        password.sendKeys("admin123");

        //Click login
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        login.click();

        Thread.sleep(3000);

        String Actual_link = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String Expected_link = driver.getCurrentUrl();
        Assert.assertEquals(Actual_link,Expected_link);
        System.out.println("testcase1 successfull!!!");
    }
    //In Test2 we are going to check whether the page is logout successfully
    @Test(priority = 2)
    public void testcase2() throws InterruptedException {

        //click dropdown
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i"));
        drop.click();

        //click logout
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
        logout.click();

        //verify whether the page is logout
        Thread.sleep(3000);
        String Actual_link = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String Expected_link = driver.getCurrentUrl();
        Assert.assertEquals(Actual_link,Expected_link);
        System.out.println("testcase 2 log-out!!!");


    }
    //Before test open url and maximize the screen
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
