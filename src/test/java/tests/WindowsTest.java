package tests;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import helperMethods.WindowsMethods;
import pages.CommonPage;
import pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsTest {
    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    WindowsMethods windowsMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void browserWindowsTests() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //setam browserul in modul maximize
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement newTabElement = driver.findElement((By.id("tabButton")));
        elementsMethods.clickOnElements(newTabElement);
        windowsMethods.switchToNewTab();
        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        windowsMethods.displayContentOfNewTab(sampleHeadingElement);
        windowsMethods.close();

        windowsMethods.switchToPreviousTab();
        WebElement newWindowsElement = driver.findElement((By.id("windowButton")));
        elementsMethods.clickOnElements(newWindowsElement);
        windowsMethods.switchToNewWindow();
        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        windowsMethods.displayContentOfNewWindow(sampleHeadingWindowElement);
        windowsMethods.close();
        windowsMethods.switchToPreviousWindow();
    }
}
