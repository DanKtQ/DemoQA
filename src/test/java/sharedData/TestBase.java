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

//        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);
//
//        //deschidem un browser de Chrome
//        driver = new ChromeDriver();
//        //accesam o pagina web
//        driver.get(configurationNode.driverConfigNode.url);
//        //setam browserul in modul maximize
//        driver.manage().window().maximize();
//        //definim un wait implicit pentru un interval maxim de timp
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
