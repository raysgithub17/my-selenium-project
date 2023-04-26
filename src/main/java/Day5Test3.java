import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

public class Day5Test3 {
    public static void main(String args[]) throws InterruptedException {
        //Driver setup
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        //url to open
        String url ="https://demo.guru99.com/test/delete_customer.php";

        //Open the url
        driver.get(url);

        //Maximize
        driver.manage().window().maximize();

        //wait for the content to load
        Thread.sleep(3000);

        //Scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)","");

        // type 401
        WebElement txt = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        txt.sendKeys("401");

        // click submit
        WebElement submit = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
        submit.click();

        //create Alert Object
        Alert alert1 = driver.switchTo().alert();

        //click cancel in alert
        alert1.dismiss();

        //clear textbox
        txt.clear();

        //type 402
        txt.sendKeys("402");

        //click submit
        submit.click();

        //create object for second alert
        Alert alert2 = driver.switchTo().alert();

        //click ok in alert
        alert2.accept();

        //create object for third alert
        Alert alert3 = driver.switchTo().alert();

        //get the message from third alert box
        String msg = alert3.getText();

        //accept the third alert box
        alert3.accept();

        System.out.println(msg);





    }
}
