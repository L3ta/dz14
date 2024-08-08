import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://demoqa.com/webtables");

            // "ADD"
            WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
            addButton.click();

            // Заповнення
            driver.findElement(By.id("firstName")).sendKeys("Roman");
            driver.findElement(By.id("lastName")).sendKeys("Polonchuk");
            driver.findElement(By.id("userEmail")).sendKeys("roman@test.com");
            driver.findElement(By.id("age")).sendKeys("28");
            driver.findElement(By.id("salary")).sendKeys("5000");
            driver.findElement(By.id("department")).sendKeys("QA");
            driver.findElement(By.id("submit")).click();

            // Перевірка
            WebElement newRow = driver.findElement(By.xpath("//div[text()='Roman']"));
            if (newRow.isDisplayed()) {
                System.out.println("New record added successfully.");
            } else {
                System.out.println("Failed to add new record.");
            }

            // Редагування
            WebElement editButton = driver.findElement(By.xpath("//span[@title='Edit']"));
            editButton.click();
            WebElement salaryField = driver.findElement(By.id("salary"));
            salaryField.clear();
            salaryField.sendKeys("6000");
            driver.findElement(By.id("submit")).click();

            // Перевірка2
            WebElement editedRow = driver.findElement(By.xpath("//div[text()='6000']"));
            if (editedRow.isDisplayed()) {
                System.out.println("Record edited successfully.");
            } else {
                System.out.println("Failed to edit record.");
            }

        } finally {
            driver.quit();
        }
    }
}