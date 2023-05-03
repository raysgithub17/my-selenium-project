package org.example;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10Test4 {
    WebDriver driver;
    static ExtentTest test;
    static ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
    String sstloc="/Users/raysmacbook/Documents/my-selenium-project/CE4.png";

    @BeforeSuite
    void init()
    {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();

        htmlReporter =  new ExtentHtmlReporter("/Users/raysmacbook/Documents/my-selenium-project/Day10Test4Report.html");
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
    @Test
    void Test1() throws InterruptedException
    {	  test = extent.createTest("Test Case 1", "The test case 1 has passed");
        String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        Thread.sleep(3000);
        WebElement uname=driver.findElement(By.name("username"));
        WebElement pwd=driver.findElement(By.name("password"));
        WebElement submit=driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        uname.sendKeys("Suvitha");
        pwd.sendKeys("12345");
        submit.click();
        String url1="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    }

    @AfterMethod
    public void getResult(ITestResult result) throws AWTException, IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            screencapture(sstloc);
            test.log(Status.FAIL,result.getThrowable());
            test.addScreenCaptureFromPath(sstloc);
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
    void screencapture(String sstloc1) throws AWTException, IOException
    {
        Robot robot=new Robot();
        Dimension scr_size=Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rect=new Rectangle(scr_size);
        BufferedImage scrshot=robot.createScreenCapture(rect);
        File dest=new File(sstloc1);
        ImageIO.write(scrshot,"png",dest);
    }


}

