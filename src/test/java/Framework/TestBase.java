package Framework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import Framework.Browser.DriverManager;

public class TestBase {
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://bugbank.netlify.app/");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}