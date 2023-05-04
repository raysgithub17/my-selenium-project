package org.example;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;




import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cia1Que3 {

    public static void main(String[] args) throws InterruptedException {

        // TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();

        ChromeOptions co=new ChromeOptions();

        co.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(co);

        driver.get("https://www.amazon.in/");

        driver.manage().window().maximize();

        String title=driver.getTitle();

        System.out.println("title:"+title);

        String htitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

        if(title.equals(htitle)) {

            System.out.println("success");

        }

        else {

            System.out.println("failed");

        }

        WebElement SignIn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        SignIn.click();

        Thread.sleep(3000);

        WebElement Email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        Email.sendKeys("9842187873");

        WebElement EmailContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        EmailContinue.click();

        WebElement Password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        Password.sendKeys("Naveenm@03");

        WebElement PasswordSign = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        PasswordSign.click();

        Thread.sleep(10000);
        WebElement

                acc=driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[1]/h1")); String actual=acc.getText();

        String expected="Your Account";

        if(actual.equals(expected)) {

            System.out.println("Your Account page is displayed");

        }

        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[1]/a/div")). click();

        WebElement

                ord=driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div[1]/div[2]/div[1 ]/h1"));

        String act=ord.getText();

        String exp="Your Orders";

        if(act.equals(exp)) {

            System.out.println("Your Order page is displayed");

        }

        //

        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[1]/a/div")) .click();

        WebElement trac=driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div[1]/div[2]/div[ 1]/h1"));

        String act1=ord.getText();

        String exp1="Your orders";

        if(act.equals(exp)) {

            System.out.println("User is able to track package");

        }


        driver.findElement(By.xpath("//*[@id=\"pop\"]/div/div[2]/div/div[1]/div/div[3]/di v/div/div/div/div[2]/div/div/a")).click();

        System.out.println("User is able to view their products");

    }
}

