package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;


public class Cc1Que1 {
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

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCartButton.click();

        // Verify that the product has been added to the cart
        Thread.sleep(3000);
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_badge"));
        assertEquals("1", cartIcon.getText());
        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart_item']"));
        String actualProductName = cartItem.findElement(By.className("inventory_item_name")).getText();
        String expectedProductName = "Sauce Labs Backpack";
        assertEquals(expectedProductName, actualProductName);
        String actualProductPrice = cartItem.findElement(By.className("inventory_item_price")).getText();
        String expectedProductPrice = "$29.99";
        assertEquals(expectedProductPrice, actualProductPrice);

        // Proceed to checkout and fill the form
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));
        firstNameField.sendKeys("mohamed");
        lastNameField.sendKeys("rayhan");
        postalCodeField.sendKeys("12345");
        continueButton.click();

        // Verify that the product overview page is displayed
        Thread.sleep(3000);
        WebElement productOverviewTitle = driver.findElement(By.className("title"));
        assertEquals("Checkout: Overview", productOverviewTitle.getText());
        WebElement productTitle = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        assertEquals(expectedProductName, productTitle.getText());
        WebElement productPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        assertEquals(expectedProductPrice, productPrice.getText());

        // Print the name and price of the product to the console
        System.out.println("Product Name: " + expectedProductName);
        System.out.println("Product Price: " + expectedProductPrice);

        // Assert the title and URL of the page
        assertEquals(expectedTitle, driver.getTitle());
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());

        // Quit the browser
        driver.quit();
    }
}
