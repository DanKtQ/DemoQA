package tests;

import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import helperMethods.AlertMethods;
import helperMethods.ElementsMethods;
import helperMethods.JavascriptMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import sharedData.Hooks;
import org.testng.annotations.Test;

public class AlertsTest extends Hooks {

    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void accessAlertsTests() {

        System.out.println("Acesta este testul de Alerts");

        elementsMethods = new ElementsMethods(getDriver());
        alertMethods = new AlertMethods(getDriver());
        javascriptMethods = new JavascriptMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Alerts");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts submenu");

        WebElement alertOkElement = getDriver().findElement(By.id("alertButton"));
        elementsMethods.clickOnElements(alertOkElement);
        //ne mutam cu focusul pe alerta si dam ok
        alertMethods.interactOKWithAlerts();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with OK Alert");

        WebElement alertDelayElement = getDriver().findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElements(alertDelayElement);
        //definim un wait explicit ca sa astepte dupa alerta
        alertMethods.explicitAlertWait();
        //ne mutam cu focusul pe alerta si dam ok
        alertMethods.interactOKWithAlerts();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with Alert Delay");

        WebElement alertConfirmationElement = getDriver().findElement(By.id("confirmButton"));
        elementsMethods.clickOnElements(alertConfirmationElement);
        //ne mutam cu focusul pe alerta si dam cancel
        alertMethods.interactDismissWithAlerts();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with Alert Confirmation");

        WebElement alertPromptElement = getDriver().findElement(By.id("promtButton"));
        elementsMethods.clickOnElements(alertPromptElement);
        //ne mutam cu focusul pe alerta, completam campul si dam OK
        alertMethods.interactAndFillWithAlert("Automation");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with Alert Prompt");
    }
}