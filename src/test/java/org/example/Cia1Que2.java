package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static org.junit.Assert.*;

public class Cia1Que2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.saucedemo.com/");

        // Enter the username and password and click on the LOGIN button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Verify that the user has successfully logged in
        String expectedTitle = "Swag Labs";
        assertEquals(expectedTitle, driver.getTitle());

        // Apply filter from A-Z
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        String name1 = productNames.get(0).getText();
        System.out.println(name1);
        WebElement sort1 = driver.findElement(By.className("product_sort_container"));
        sort1.click();
        Select s1=new Select(sort1);



        // Apply filter from Z-A
        Thread.sleep(3000);
        sort1.click();
        s1.selectByIndex(1);
        List<WebElement> productNames2 = driver.findElements(By.className("inventory_item_name"));
        String name2 = productNames2.get(0).getText();
        System.out.println(name1);



        // Apply filter from low price to high price
        Thread.sleep(3000);
        WebElement sort2 = driver.findElement(By.className("product_sort_container"));
        Select s2=new Select(sort2);
        sort2.click();
        s2.selectByIndex(2);
        List<WebElement> productPrices1 = driver.findElements(By.className("inventory_item_price"));
        String price1 = productPrices1.get(0).getText();
        System.out.println(price1);



        // Apply filter from high price to low price
        Thread.sleep(3000);
        WebElement sort3 = driver.findElement(By.className("product_sort_container"));
        Select s3=new Select(sort3);
        sort3.click();
        s3.selectByIndex(3);
        List<WebElement> productPrices2 = driver.findElements(By.className("inventory_item_price"));
        String price2 = productPrices2.get(0).getText();
        System.out.println(price2);


        // Quit the browser
        driver.quit();
    }
}
