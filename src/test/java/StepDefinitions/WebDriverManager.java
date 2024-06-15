package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            Properties properties = new Properties();
            try {
                FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            String websiteUrl = properties.getProperty("websiteUrl");

            // Set up Chrome options
            ChromeOptions options = new ChromeOptions();
            // Set any additional options if needed

            // Initialize ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/mychrome/chromedriver.exe"); // Ensure this path is correct
            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.get(websiteUrl);
            driverThreadLocal.set(driver);
        }
        return driver;
    }
}
