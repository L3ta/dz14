import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://demoqa.com/elements");

            //"Buttons"
            WebElement buttonsTab = driver.findElement(By.xpath("//span[text()='Buttons']"));
            buttonsTab.click();

            //"Click Me"
            WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
            clickMeButton.click();

            WebElement message = driver.findElement(By.id("dynamicClickMessage"));
            System.out.println("Message: " + message.getText());

        } finally {
            driver.quit();
        }
    }
}

