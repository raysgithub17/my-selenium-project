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

import java.util.concurrent.TimeUnit;

public class Day7Test6 {
    WebDriver driver;

    @Test(groups = {"SmokeTest"})
    public void testcase1() throws InterruptedException {

        driver = new EdgeDriver();
        String url = "https://www.godaddy.com/en-in";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String Actual_url = "https://www.godaddy.com/en-in";
        String Expected_url = driver.getCurrentUrl();

        String Actual_title = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
        String Expected_title = driver.getTitle();

        Assert.assertEquals(Actual_title,Expected_title);
        Assert.assertEquals(Actual_url,Expected_url);

        driver.close();
    }

    @Test(groups = {"Regression"})
    public void testcase2() throws InterruptedException {
        driver = new EdgeDriver();
        String url = "https://www.godaddy.com/en-in";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement domain = driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button"));
        domain.click();

        WebElement dns =driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a"));
        dns.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.close();

    }

    @Test(groups = {"Regression"})
    public void testcase3() throws InterruptedException {
        driver = new EdgeDriver();
        String url = "https://www.godaddy.com/en-in";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement domain = driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button"));
        domain.click();

        WebElement dns =driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a"));
        dns.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       String Actual_title = "GoDaddy Domain Search - Buy and Register Available Domain Names";
       String Expected_title = driver.getTitle();

       Assert.assertEquals(Actual_title,Expected_title);

       WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"8469f0c3-e08f-4343-9756-ce0390b0d581\"]"));
        boolean isSearchBoxEnabled = searchBox.isEnabled();
        System.out.println("Is search box enabled? " + isSearchBoxEnabled);

        WebElement buyItButton = driver.findElement(By.xpath("//*[@id=\"id-1467954b-c5e3-4b0c-9046-9fc94d8ca892\"]/section/div/div/section/div/div[1]/div/div/div[2]/button"));
        boolean isBuyItButtonPresent = buyItButton.isDisplayed();
        System.out.println("Is 'Buy It' button present? " + isBuyItButtonPresent);

        searchBox.sendKeys("mydomain");
        buyItButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div/div/div[2]/button"));
        boolean isAddToCartButtonPresent = addToCartButton.isDisplayed();
        System.out.println("Is 'Add to Cart' button present? " + isAddToCartButtonPresent);

        WebElement domainPrice = driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]/span"));
        String price = domainPrice.getText();
        System.out.println("Price of the domain is: " + price);

        driver.close();

    }
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        WebDriverManager.edgedriver().setup();

    }

    @AfterTest
    public void afterTest() {

    }
}
