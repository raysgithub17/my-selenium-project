package org.example;


import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Day7Test1 {
    WebDriver driver;
    @Test
    public void f() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

}