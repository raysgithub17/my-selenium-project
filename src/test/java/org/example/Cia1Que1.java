package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;

public class Cia1Que1 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to Amazon website
        driver.get("https://www.amazon.in");

        Thread.sleep(3000);
        // Print page title
        System.out.println("Page title: " + driver.getTitle());

        // Validate page title
        if (driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
            System.out.println("Page title validation passed.");
        } else {
            System.out.println("Page title validation failed.");
        }
        // Login
        WebElement SignIn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
        SignIn.click();
        Thread.sleep(3000);
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
        Email.sendKeys("smdrayhan2002@gmail.com");
        Thread.sleep(3000);
        WebElement EmailContinue = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        EmailContinue.click();
        Thread.sleep(3000);
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        Password.sendKeys("rayhan675445");
        Thread.sleep(3000);
        WebElement PasswordSign = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        PasswordSign.click();
        Thread.sleep(10000);


        // 1. Add a product to the cart
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone 12");
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement productLink = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        productLink.click();
        Thread.sleep(3000);
        ArrayList<String> wid=new ArrayList<String>(driver.getWindowHandles());
        System.out.println(wid.get(1));
        driver.switchTo().window((wid.get(1)));
        Thread.sleep(3000);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        //add to the cart
        WebElement name = driver.findElement(By.xpath("//*[@id=\"productTitle\"]"));
        String nametxt = name.getText();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        System.out.println(nametxt+" is added to your cart");
        Thread.sleep(3000);


        // 2. Remove a product from the cart
        driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
        Thread.sleep(10000);
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"sc-active-fa1072b9-8406-4778-abeb-420238df517d\"]/div[4]/div/div[3]/div[1]/span[2]/span/input"));
        deleteButton.click();
        System.out.println(nametxt+" is deleted from your cart");
        Thread.sleep(3000);




        // 4. Proceed to the checkout page
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));
        proceedToCheckoutButton.click();
        Thread.sleep(3000);

        // 5. Verify the checkout process and total cost
        WebElement totalPriceLabel = driver.findElement(By.xpath("//*[@id=\"subtotals-marketplace-table\"]/tbody/tr[4]/td[2]"));
        String totalPrice = totalPriceLabel.getText();
        System.out.println("your in the checkout");
        System.out.println("Total price: " + totalPrice);

        // Close the browser
        driver.quit();
    }
}
