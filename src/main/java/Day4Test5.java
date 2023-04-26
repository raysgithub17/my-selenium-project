import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Day4Test5 {
    public static void main(String [] args) throws InterruptedException {
        // Driver setup
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();

        // URL to open
        String url = "https://j2store.net/free/";

        // Open the URL
        driver.get(url);

        // Maximize
        driver.manage().window().maximize();

        //Wait for load the content
        Thread.sleep(3000);

        //scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        String t1 = driver.getCurrentUrl();
        System.out.println(t1);

        if(t1.equals(url)){
            System.out.println("correct url");
        }
        else{
            System.out.println("wrong url");
        }

        //click clothing
        WebElement clothing = driver.findElement(By.xpath("//*[@id=\"Mod112\"]/div/div/ul/li[1]/h4/a"));
        clothing.click();

        //define clothing page url
        String cloth_url = "https://j2store.net/free/index.php/shop?filter_catid=11";

        //get clothing page url
        String t2 = driver.getCurrentUrl();
        System.out.println(t2);

        //validate clothing url

        if(cloth_url.equals(t2)){
            System.out.println("correct url");
        }
        else{
            System.out.println("wrong url");
        }

    }
}
