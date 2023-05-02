package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Day9Test5 {
    WebDriver driver;
    //In Test1 we have to verify that the page is loaded successfully
    @Test
    public void test() throws InterruptedException {
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

    //Before test open url and maximize the screen
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
