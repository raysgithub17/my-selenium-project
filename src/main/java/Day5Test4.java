import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Day5Test4 {
    public static void main(String args[]) throws InterruptedException {
        // Driver setup
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();

        // URL to open
        String url = "https://www.abhibus.com/bus-ticket-booking";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        //Wait for load the content
        Thread.sleep(3000);

        //scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        //type the source
        WebElement source = driver.findElement(By.xpath("//*[@id=\"source\"]"));
        source.sendKeys("Coimbatore");

        //type the destination
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"destination\"]"));
        destination.sendKeys("Chennai");

        //define Datepick object
        WebElement datepick = driver.findElement(By.xpath("//*[@id=\"datepicker1\"]"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].setAttribute('value','01/10/2023')",datepick);


    }
}
