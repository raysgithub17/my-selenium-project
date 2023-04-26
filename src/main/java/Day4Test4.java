import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.sql.Driver;

public class Day4Test4 {
    public static void main(String args[]) throws InterruptedException {

        //Driver setup
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        //url to open
        String url ="https://j2store.net/free/";

        //Open the url
        driver.get(url);

        //Maximize
        driver.manage().window().maximize();

        //wait for the content to load
        Thread.sleep(3000);

        //Scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        //click clothing
        WebElement clothing = driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/h4/a"));
        clothing.click();

        //navigate back
        driver.navigate().back();
        Thread.sleep(3000);
        //navigate front
        driver.navigate().forward();
        Thread.sleep(3000);
        //navigate refresh
        driver.navigate().refresh();
        Thread.sleep(3000);
        //close the browser
        driver.close();



    }
}
