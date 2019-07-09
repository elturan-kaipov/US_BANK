package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;


    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = Config.getProperty("browser");

            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("chrome-headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("firefox-headless".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
            } else if ("ie".equals(browser)) {
                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    throw new WebDriverException("Your operating system does not support the requested browser");
                }
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("edge".equals(browser)) {
                if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    throw new WebDriverException("Your operating system does not support the requested browser");
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if ("safari".equals(browser)) {
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    throw new WebDriverException("Your operating system does not support the requested browser");
                }
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


