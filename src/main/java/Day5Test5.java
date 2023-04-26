import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Day5Test5 {
    public static void main(String args[]){
        // Driver setup
        WebDriverManager.edgedriver().setup();

        // Launch 3 Edge browsers
        WebDriver driver1 = new EdgeDriver();
        WebDriver driver2 = new EdgeDriver();
        WebDriver driver3 = new EdgeDriver();

        // Navigate to Google.com on all 3 browsers
        driver1.get("https://www.google.com");
        driver2.get("https://www.google.com");
        driver3.get("https://www.google.com");

        // Search for "Apple" on the first browser
        WebElement searchBox1 = driver1.findElement(By.name("q"));
        searchBox1.sendKeys("Apple");
        searchBox1.submit();

        // Search for "Selenium" on the second browser
        WebElement searchBox2 = driver2.findElement(By.name("q"));
        searchBox2.sendKeys("Selenium");
        searchBox2.submit();

        // Search for "Cucumber" on the third browser
        WebElement searchBox3 = driver3.findElement(By.name("q"));
        searchBox3.sendKeys("Cucumber");
        searchBox3.submit();

        // Print the window IDs and page titles of all 3 browsers
        System.out.println("Window ID 1: " + driver1.getWindowHandle());
        System.out.println("Title 1: " + driver1.getTitle());
        System.out.println("Window ID 2: " + driver2.getWindowHandle());
        System.out.println("Title 2: " + driver2.getTitle());
        System.out.println("Window ID 3: " + driver3.getWindowHandle());
        System.out.println("Title 3: " + driver3.getTitle());

        // Quit all 3 browsers
        driver1.quit();
        driver2.quit();
        driver3.quit();
    }
}
