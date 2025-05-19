package sharedData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    private WebDriver driver;

    // BeforeMethod si AfterMethod se folosesc cu testng
    // BeforeEach si AfterEach se folosesc cu junit
    @BeforeMethod
    public void setUp() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //setam browserul in modul maximize
        driver.manage().window().maximize();
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
