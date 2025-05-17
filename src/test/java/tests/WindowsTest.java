package tests;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import helperMethods.WindowsMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.TestBase;

public class WindowsTest extends TestBase {
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    WindowsMethods windowsMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void browserWindowsTests() {

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
