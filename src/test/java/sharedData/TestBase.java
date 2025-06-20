package sharedData;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import sharedData.browser.BrowserFactory;

public class TestBase {

    private WebDriver driver;

    // BeforeMethod si AfterMethod se folosesc cu testng
    // BeforeEach si AfterEach se folosesc cu junit
    public void setUp() {
        driver = new BrowserFactory().getBrowserFactory();
        LoggerUtility.infoLog("The browser was opened with success");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        LoggerUtility.infoLog("The browser was closed with success");
    }

    public WebDriver getDriver() {

        return driver;
    }
}
