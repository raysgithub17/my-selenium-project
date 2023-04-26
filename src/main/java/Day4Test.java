import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
public class Day4Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Driver setup
        //Chrome driver

//        		WebDriverManager.chromedriver().setup();
//            	ChromeOptions co=new ChromeOptions();
//            	co.addArguments("--remote-allow-origins=*");
//        		WebDriver driver=new ChromeDriver(co);

        //edge driver

        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();


        driver.get("https://google.com");

        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Hello");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.findElement(By.className("gN089b")).submit();

    }
}
