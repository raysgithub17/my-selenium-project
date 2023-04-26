import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Day5Test1 {
    public static void main(String [] args) throws InterruptedException {
        //Driver setup
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        //url to open
        String url ="https://demoqa.com/droppable/";

        //Open the url
        driver.get(url);

        //Maximize
        driver.manage().window().maximize();

        //wait for the content to load
        Thread.sleep(3000);

        //Scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        //Create Action
        Actions a =new Actions(driver);

        //drag
        WebElement drag = driver.findElement(By.id("draggable"));

        //drop
        WebElement drop = driver.findElement(By.id("droppable"));

        //drag and drop
        a.clickAndHold(drag).release(drop).build().perform();
    }
}
