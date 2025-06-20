package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import helperMethods.WindowsMethods;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.Hooks;

public class WindowsTest extends Hooks {
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
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Browser Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Browser Windows submenu");

        WebElement newTabElement = getDriver().findElement((By.id("tabButton")));
        elementsMethods.clickOnElements(newTabElement);
        windowsMethods.switchToNewTab();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user switches to new tab");
        WebElement sampleHeadingElement = getDriver().findElement(By.id("sampleHeading"));
        windowsMethods.displayContentOfNewTab(sampleHeadingElement);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user sees content of new tab");
        windowsMethods.close();

        windowsMethods.switchToPreviousTab();
        WebElement newWindowsElement = getDriver().findElement((By.id("windowButton")));
        elementsMethods.clickOnElements(newWindowsElement);
        windowsMethods.switchToNewWindow();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user switches to new window");
        WebElement sampleHeadingWindowElement = getDriver().findElement(By.id("sampleHeading"));
        windowsMethods.displayContentOfNewWindow(sampleHeadingWindowElement);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user sees content of new window");
        windowsMethods.close();
        windowsMethods.switchToPreviousWindow();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user switches to previous window");
    }
}
