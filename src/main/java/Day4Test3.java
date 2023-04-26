

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class Day4Test3 {
    public static void main(String[] args) throws InterruptedException {

        // Driver setup
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();

        // URL to open
        String url = "https://demo.opencart.com/index.php?route=account/register&language=en-gb";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        //Wait for load the content
        Thread.sleep(3000);

        //scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        // First Name
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        firstName.sendKeys("Mohamed");

        // Last Name
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        lastName.sendKeys("Rayhan");

        // Email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        email.sendKeys("smdrayhan.com");

        // Password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        password.sendKeys("password");


        // Subscribe
        WebElement subscribe = driver.findElement(By.xpath("//*[@id=\"input-newsletter-yes\"]"));
        subscribe.click();

        // Close the browser
        // driver.quit();
    }
}
