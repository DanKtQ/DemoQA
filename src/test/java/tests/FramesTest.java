package tests;

import helperMethods.ElementsMethods;
import helperMethods.FramesMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.TestBase;
import org.testng.annotations.Test;

public class FramesTest extends TestBase {
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
        commonPage.goToDesiredSubMenu("Frames");

        WebElement frame1Element = getDriver().findElement((By.id("frame1")));
        framesMethods.switchToFrame(frame1Element);
        WebElement sampleHeadingFrameElement = getDriver().findElement(By.id("sampleHeading"));
        framesMethods.displayContentOfFrame(sampleHeadingFrameElement);

        //ne ducem cu focusul inapoi pe pagina principala
        framesMethods.switchToMainContent();
        //ne ducem cu focusul pe frame-ul 2
        WebElement frame2Element = getDriver().findElement((By.id("frame2")));
        framesMethods.switchToFrame(frame2Element);
        //facem un scroll atat pe axa x, cat si pe axa y
        javascriptMethods.scroll(200, 200);
    }
}
