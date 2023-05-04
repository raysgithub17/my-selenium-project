package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class summa {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement signin = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
        signin.click();

        Thread.sleep(3000);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email.sendKeys("727721eucs075@skcet.ac.in");

        WebElement next1 = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
        next1.click();

        Thread.sleep(3000);

        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pwd.sendKeys("Skcet@1705");

        WebElement next2 = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        next2.click();







    }
}
