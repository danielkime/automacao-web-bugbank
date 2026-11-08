package Framework.Browser;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            
            // Desativa o preenchimento automático e cache do Chrome para evitar concatenação de inputs
            options.addArguments("--disable-autofill");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-notifications");
            
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("autofill.profile_enabled", false);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}