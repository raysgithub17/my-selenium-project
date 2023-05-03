package org.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Day10Test123 {
    static ExtentTest test;
    static ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
    @BeforeClass
    public void startreport()
    {
        htmlReporter =  new ExtentHtmlReporter("/Users/raysmacbook/Documents/my-selenium-project/Day10Test123Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    WebDriver driver;

    @Test
    public void testcase1() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
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
        test = extent.createTest("Test Case 1", "The test case 1 has passed");
    }

    @Test
    public void testcase2() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        String url =  "https://www.godaddy.com/en-in";
        driver.get(url);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement domain = driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/button"));
        domain.click();

        WebElement dns =driver.findElement(By.xpath("//*[@id=\"id-631b049a-e9c0-4d24-8710-c504745206dd\"]/div[2]/div[1]/ul/li[1]/div/div[2]/div[1]/ul/li[2]/a"));
        dns.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.close();
        test = extent.createTest("Test Case 2", "The test case 2 has passed");

    }
    @Test
    public void testcase3() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        String url =  "https://www.godaddy.com/en-in";
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
        test = extent.createTest("Test Case 3", "The test case 3 has passed");
    }
    @AfterMethod
    //getstatus returns status (pass or fail) of the test
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
    }
    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }

}