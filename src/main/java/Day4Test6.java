import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Day4Test6 {
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

        //select parent element
        //WebElement parentElement = driver.findElement(By.xpath("//*[@id=\"akeeba-renderjoomla\"]/div/div/div[1]/div[1]/div[1]/div/h2"));
        //List<WebElement> l1= parentElement;
        List <WebElement> l1=driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));
        for(WebElement link:l1){
            System.out.println(link.getText());
        }

    }
}
