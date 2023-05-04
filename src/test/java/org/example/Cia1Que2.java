package org.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cia1Que2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int productCount = 0;
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(co);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone12");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

        List<WebElement> tiltleElements = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));

        for (WebElement titleElement : tiltleElements) {
            System.out.println(titleElement.getText());
            productCount++;
            if(productCount == 5) {
                break;
            }
        }

        System.out.println("===========================================================");
        WebElement sort = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
        sort.click();
        System.out.println("Applied Filter!");
        WebElement lhfilter = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_1\"]"));
        lhfilter.click();
        System.out.println("Applied Filter based on Price");
        sort.click();
        WebElement reviewfilter = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_3\"]"));
        reviewfilter.click();
        System.out.println("Applied Filter based on Reviews");

    }

}