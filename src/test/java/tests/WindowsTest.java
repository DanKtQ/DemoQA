package tests;

import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import helperMethods.WindowsMethods;
import org.testng.annotations.Test;
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

        elementsMethods = new ElementsMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        windowsMethods = new WindowsMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement newTabElement = getDriver().findElement((By.id("tabButton")));
        elementsMethods.clickOnElements(newTabElement);
        windowsMethods.switchToNewTab();
        WebElement sampleHeadingElement = getDriver().findElement(By.id("sampleHeading"));
        windowsMethods.displayContentOfNewTab(sampleHeadingElement);
        windowsMethods.close();

        windowsMethods.switchToPreviousTab();
        WebElement newWindowsElement = getDriver().findElement((By.id("windowButton")));
        elementsMethods.clickOnElements(newWindowsElement);
        windowsMethods.switchToNewWindow();
        WebElement sampleHeadingWindowElement = getDriver().findElement(By.id("sampleHeading"));
        windowsMethods.displayContentOfNewWindow(sampleHeadingWindowElement);
        windowsMethods.close();
        windowsMethods.switchToPreviousWindow();
    }
}
