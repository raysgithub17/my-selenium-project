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

public class Day7Test4 {
    WebDriver driver;
    @Test
    public void test1() throws InterruptedException {

        //Enter user name
        WebElement user_id = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        user_id.sendKeys("Admin");

        //Enter password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        password.sendKeys("admin123");

        //Click login
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        login.click();

        //Assert whether the profile link and current link is same
        String profile_link = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String current_link = driver.getCurrentUrl();
        Assert.assertEquals(current_link,profile_link);

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
