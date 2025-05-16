package tests;

import helperMethods.ElementsMethods;
import helperMethods.FramesMethods;
import helperMethods.JavascriptMethods;
import pages.CommonPage;
import pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTest {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    FramesMethods framesMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void FramesTests() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //setam browserul in modul maximize
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        framesMethods = new FramesMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");

        WebElement frame1Element = driver.findElement((By.id("frame1")));
        framesMethods.switchToFrame(frame1Element);
        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        framesMethods.displayContentOfFrame(sampleHeadingFrameElement);

        //ne ducem cu focusul inapoi pe pagina principala
        framesMethods.switchToMainContent();
        //ne ducem cu focusul pe frame-ul 2
        WebElement frame2Element = driver.findElement((By.id("frame2")));
        framesMethods.switchToFrame(frame2Element);
        //facem un scroll atat pe axa x, cat si pe axa y
        javascriptMethods.scroll(200, 200);
    }
}
