package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day7Test2 {
    WebDriver driver;
    @Test
    public void f() throws InterruptedException {
        String t1 = driver.getTitle();
        System.out.println(t1);
        String t2 = "Guest Registration Form – User Registration";
        Assert.assertEquals(t1,t2);

    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        String url = "https://demo.wpeverest.com/user-registration/guest-registration-form/";
        driver.get(url);


    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
