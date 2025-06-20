package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import helperMethods.ElementsMethods;
import helperMethods.FramesMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.Hooks;
import org.testng.annotations.Test;

public class FramesTest extends Hooks {
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    FramesMethods framesMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void FramesTests() {

        System.out.println("Acesta este testul de Frames");

        elementsMethods = new ElementsMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        framesMethods = new FramesMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Frames");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Frames submenu");

        WebElement frame1Element = getDriver().findElement((By.id("frame1")));
        framesMethods.switchToFrame(frame1Element);
        WebElement sampleHeadingFrameElement = getDriver().findElement(By.id("sampleHeading"));
        framesMethods.displayContentOfFrame(sampleHeadingFrameElement);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with the first iframe");

        //ne ducem cu focusul inapoi pe pagina principala
        framesMethods.switchToMainContent();
        //ne ducem cu focusul pe frame-ul 2
        WebElement frame2Element = getDriver().findElement((By.id("frame2")));
        framesMethods.switchToFrame(frame2Element);
        //facem un scroll atat pe axa x, cat si pe axa y
        javascriptMethods.scroll(200, 200);
    }
}
