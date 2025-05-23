package sharedData;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sharedData.browser.BrowserFactory;

public class TestBase {

    private WebDriver driver;

    // BeforeMethod si AfterMethod se folosesc cu testng
    // BeforeEach si AfterEach se folosesc cu junit
    @BeforeMethod
    public void setUp() {

        driver = new BrowserFactory().getBrowserFactory();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
